package cn.bdqn.warehousemanager.service.user;

import cn.bdqn.warehousemanager.communal.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@FeignClient(value = "WAREHOUSEHOME")
public interface UserService2 {
    //进入添加用户界面
    @GetMapping("/api/user/adduser")
    public String addUserHtml();

    //添加用户
    @RequestMapping(value = "/api/user/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody UserVO user);

    //所以用户展示界面
    @PostMapping("/api/user/index")
    public String getUserAll(@RequestBody UserVO vo);


    /**
     * 文件导出
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/api/user/export")
    public void export(@RequestBody HttpServletResponse response) throws IOException;

    @RequestMapping(value = "/api/user/import")
    public String exImport(@RequestBody MultipartFile filename);

    @GetMapping("/api/user/delete")
    public String deletUserById(@RequestParam("id") Integer id);

    //进入添加用户界面
    @GetMapping("/api/user/editUserHtml")
    public String editUserHtml(@RequestParam("id") Integer id);

    //编辑用户
    @RequestMapping(value = "/api/user/editUser", method = RequestMethod.POST)
    public String editUser(@RequestBody UserVO user);
}
