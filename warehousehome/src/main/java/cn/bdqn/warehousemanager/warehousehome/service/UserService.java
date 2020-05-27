package cn.bdqn.warehousemanager.warehousehome.service;


import cn.bdqn.warehousemanager.communal.entity.UserVO;
import cn.bdqn.warehousemanager.warehousehome.config.MyException;
import cn.bdqn.warehousemanager.warehousehome.service.mail.MailService;
import cn.bdqn.warehousemanager.warehousehome.service.role.RoleService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import cn.bdqn.warehousemanager.warehousehome.mapper.user.UserMapper;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    MailService mailService;
    @Autowired
    RoleService roleService;


    public Integer addUser(UserVO user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        user.setCreationTime(sf.format(new Date()));
        int result = userMapper.addUser(user);
        System.out.println(user.getId());
        System.out.println(user.getRid());
        System.out.println(result);
        //添加用户角色
        roleService.addUserRole(user.getRid(), user.getId());
        //邮件通知发送
//        Context context = new Context();
//        context.setVariable("username", user.getUsername());
//        context.setVariable("id", user.getId());
//        String mail = templateEngine.process("mailtemplate.html", context);
//        mailService.sendHtmlMail("1326293136@qq.com", user.getEmail(), "账户添加", mail);

        return result;
    }

    public List<UserVO> getUserAll(UserVO vo) {
        return userMapper.getUserAll(vo);
    }


    public int getUserAllCount(UserVO userVO) {
        return userMapper.getUserAllCount(userVO);
    }


    public Integer deleteUserById(Integer id) {
        //删除原有角色
        roleService.deleteUserRoleByuId(id);
        return userMapper.deleteUserById(id);
    }


    public UserVO getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public Integer updateUserById(UserVO userVO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(userVO.getPassword());
        userVO.setPassword(encodePassword);
        //删除原有角色
        roleService.deleteUserRoleByuId(userVO.getId());
        //添加用户角色
        roleService.addUserRole(userVO.getRid(), userVO.getId());

        return userMapper.updateUserById(userVO);
    }

    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<UserVO> userVOList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        //使用正则表达式确认文件是03版本还是07版本
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();//获得写流
        Workbook wb = null;
        //根据版本不同实例化不同的对象
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        //2、读取工作表
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        UserVO userVO;//获取用户实例
        for (int r = 2; r <= sheet.getLastRowNum(); r++) {//循环读取数据，从第三行开始
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null) {
                continue;
            }
            userVO = new UserVO();
            if (row.getCell(0).getCellType() != 1) {//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }

            String username = row.getCell(0).getStringCellValue();//得到第一给单元格的值
            if (username == null || username.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名未填写)");
            }
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String password = row.getCell(1).getStringCellValue();
            if (password == null || password.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,密码未填写)");
            }
            String phone = row.getCell(2).getStringCellValue();
            String email = row.getCell(3).getStringCellValue();
            String creationTime = row.getCell(4).getStringCellValue();
            String founder = row.getCell(5).getStringCellValue();
            String enabled = row.getCell(6).getStringCellValue();
            String locked = row.getCell(7).getStringCellValue();
            String reaName = row.getCell(8).getStringCellValue();
            String did = row.getCell(9).getStringCellValue();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            userVO.setUsername(username);
            userVO.setPhone(phone);
            userVO.setEmail(email);
            userVO.setCreationTime(creationTime);
            userVO.setFounder(founder);
            userVO.setReaName(reaName);
            userVO.setDid(Integer.parseInt(did));
            userVO.setPassword(encoder.encode(password));
            userVOList.add(userVO);
        }
        for (UserVO userVOResord : userVOList) {
            String name = userVOResord.getUsername();
            int cnt = userMapper.getUserNmaeCount(name);
            if (cnt == 0) {
                userMapper.addUser(userVOResord);
                System.out.println(" 插入 " + userVOResord);
            } else {
                userMapper.updateUserById(userVOResord);
                System.out.println(" 更新 " + userVOResord);
            }
        }
        return notNull;
    }

    public Integer getUserNmaeCount(String name) {
        return userMapper.getUserNmaeCount(name);
    }
}
