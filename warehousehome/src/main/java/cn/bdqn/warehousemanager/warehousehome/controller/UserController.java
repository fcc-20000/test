package cn.bdqn.warehousemanager.warehousehome.controller;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.entity.UserVO;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.communal.util.Page;
import cn.bdqn.warehousemanager.warehousehome.service.UserService;
import cn.bdqn.warehousemanager.warehousehome.service.department.DepartmentService;
import cn.bdqn.warehousemanager.warehousehome.service.role.RoleService;
import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;


    //进入添加用户界面
    @GetMapping("/adduser")
    public String addUserHtml() {
        List<Role> roles = roleService.getRolesAll();
        List<Department> departments = departmentService.getDepartmentAll(new Department());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roles", roles);
        modelAndView.addObject("departments", departments);
        System.out.println("进入用户添加页面");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    //添加用户
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody UserVO user) {
        int reuslt = 0;
        System.out.println(user);
        System.out.println("进入用户添加");
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.getRolesAll();
        List<Department> departments = departmentService.getDepartmentAll(new Department());
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("departments", departments);
        reuslt = userService.getUserNmaeCount(user.getUsername());
        if (reuslt > 0) {
            CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "用户名已存在！", modelAndView);
            return JSON.toJSONString(commonResult);
        }

        reuslt = userService.addUser(user);
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "添加用户成功！", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    //所以用户展示界面
    @PostMapping("/index")
    public String getUserAll(@RequestBody UserVO vo) {
        if (vo.getPageNo() == null) {
            vo.setPageNo(1);
        }
        System.out.println("进入用户管理页面");
        ModelAndView modelAndView = new ModelAndView();
        int total = userService.getUserAllCount(vo);
        Page page = new Page(vo.getPageNo(), 3, total);
        vo.setPageNo(page.getBeginPos());
        vo.setPageSize(page.getPageSize());
        List<UserVO> userVOS = userService.getUserAll(vo);
        page.setRows(userVOS);
        modelAndView.addObject("pages", page);
        List<Role> roles = roleService.getRolesAll();
        List<Department> departments = departmentService.getDepartmentAll(new Department());
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("departments", departments);
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }


    /**
     * 文件导出
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(@RequestBody HttpServletResponse response) throws IOException {
        System.out.println("文件导出");
        UserVO userVO = new UserVO();
        List<UserVO> users = userService.getUserAll(userVO);//获得所有数据
        //获得 excel的文档对象
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");//创建一个excel表单

        //  excel的行
        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("用户信息列表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *四个参数：起始行号，终止行号， 起始列号，终止列号
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(rowRegion);

        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);//获取第二行
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("用户Id");//为第一个单元格设值
        row.createCell(1).setCellValue("用户名");//为第二个单元格设值
        row.createCell(2).setCellValue("用户姓名");//为第三个单元格设值
        row.createCell(3).setCellValue("邮箱");//为第三个单元格设值
        row.createCell(4).setCellValue("手机号");//为第三个单元格设值
        row.createCell(5).setCellValue("创建时间");//为第三个单元格设值
        row.createCell(6).setCellValue("所属部门");//为第三个单元格设值
        row.createCell(7).setCellValue("系统角色");//为第三个单元格设值

        //循环导入数值
        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 2);
            UserVO user = users.get(i);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getUsername());
            row.createCell(2).setCellValue(user.getReaName());
            row.createCell(3).setCellValue(user.getEmail());
            row.createCell(4).setCellValue(user.getPhone());
            row.createCell(5).setCellValue(user.getCreationTime());
            row.createCell(6).setCellValue(user.getDepartmentName());
            row.createCell(7).setCellValue(user.getName());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));//设置默认行高
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            // 调整每一列宽度
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");//色织编码格式
        OutputStream os = response.getOutputStream();//下载工具类
        response.setHeader("Content-disposition", "attachment;filename=user.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    @RequestMapping(value = "/import")
    public String exImport(@RequestBody MultipartFile filename) {
        boolean a = false;
        String fileName = filename.getOriginalFilename();
        try {
            a = userService.batchImport(fileName, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }


    @GetMapping("/delete")
    public String deletUserById(Integer id) {
        System.out.println("进入用户删除方法");
        String prompt;
        Integer result = userService.deleteUserById(id);
        List<String> list = new ArrayList<>();
        if (result > 0) {
            prompt = "删除成功";

        } else {
            prompt = "删除失败";
        }
        list.add(prompt);
        return JSON.toJSONString(list);
    }

    //进入修改用户界面
    @GetMapping("/editUserHtml")
    public String editUserHtml(Integer id) {
        List<Role> roles = roleService.getRolesAll();
        List<Department> departments = departmentService.getDepartmentAll(new Department());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("departments", departments);
        System.out.println("进入用户修改页面");
        UserVO userVO = userService.getUserById(id);
        modelAndView.addObject("user", userVO);
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    //编辑用户
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@RequestBody UserVO user) {
        String message;
        System.out.println("进入编辑用户");
        System.out.println(user.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<Role> roles = roleService.getRolesAll();
        List<Department> departments = departmentService.getDepartmentAll(new Department());
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("departments", departments);
        int result = userService.updateUserById(user);
        if (result > 0) {
            message = "修改成功！";
        } else {
            message = "修改失败！";
        }
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, message, modelAndView);
        return JSON.toJSONString(commonResult);
    }

}
