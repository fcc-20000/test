package cn.bdqn.warehousemanager.controller;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.entity.UserVO;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.communal.util.Page;
import cn.bdqn.warehousemanager.entity.TableHeaderExcelProperty;
import cn.bdqn.warehousemanager.service.UserService;
import cn.bdqn.warehousemanager.service.user.UserService2;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@Api(value = "用户信息查询", tags = {"用户信息的controller"})
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService2 userService;

    //进入添加用户界面
    @ApiOperation(value = "进入用户添加页面", notes = "转发到前端页面",httpMethod = "GET")
    @GetMapping("/adduser")
    public ModelAndView addUserHtml() {
        String result = userService.addUserHtml();
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        UserVO userVO = new UserVO();
        modelAndView.addObject("user", userVO);//第一次进入时显示的数据（都为空）
        modelAndView.setViewName("adduser");
        return modelAndView;
    }


    //添加用户
    @ApiOperation(value = "用户添加方法")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user", value = "用户对象", dataType = "UserVO")
    )
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid UserVO user, BindingResult results, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String message;
        if (results.hasErrors()) {
            message = results.getFieldError().getDefaultMessage();
            modelAndView.addObject("message", message);
            modelAndView.addObject("user", user);//出现错误时的数据回显
            return modelAndView;
        }
        //获取用户创建人
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String founder = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
        user.setFounder(founder);
        String result = userService.addUser(user);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.addObject("message", commonResult.getMessage());
        modelAndView.addObject("user", new UserVO());
        modelAndView.setViewName("adduser");
        return modelAndView;
    }

    //所以用户展示界面
    @ApiOperation(value = "用户界面方法")
    @GetMapping("/index")
    public ModelAndView getUserAll(UserVO vo) {
        if (vo == null) {
            vo = new UserVO();
        }
        String result = userService.getUserAll(vo);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.addObject("user", vo);//查询的数据回显
        modelAndView.setViewName("userIndex");
        return modelAndView;
    }


    /**
     * 文件导出
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        String filePath = "/home/chenmingjian/Downloads/测试.xlsx";
        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();

    }

    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename") MultipartFile file, HttpSession session) {
        String result = userService.exImport(file);
        System.out.println(result);
        return "redirect:/api/user/index";
    }


    @GetMapping("/delete")
    @ResponseBody
    public String deletUserById(Integer id) {
        System.out.println("进入删除方法");
        return userService.deletUserById(id);
    }

    //用户修改界面
    @GetMapping("/editUser")
    public ModelAndView editUser(Integer id) {
        String result = userService.editUserHtml(id);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    //编辑用户
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(UserVO user, BindingResult results, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String message;
        if (results.hasErrors()) {
            modelAndView.addObject("message", results.getFieldError().getDefaultMessage());
            return modelAndView;
        }
        String result = userService.editUser(user);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.addObject("message", commonResult.getMessage());
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

}
