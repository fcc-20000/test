package cn.bdqn.warehousemanager.controller;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.service.role.RoleFegin;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class RoleController {
    @Autowired
    RoleFegin roleFegin;

    //进入角色管理表
    @GetMapping("/roleIndex")
    public ModelAndView roleIndex(Role role) {
        if (role == null) {
            role = new Role();
        }

        String result = roleFegin.roleIndex(role);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.addObject("role", role);
        modelAndView.setViewName("roleIndex");
        return modelAndView;
    }

    /**
     * 进入添加用户界面
     *
     * @return
     */
    @GetMapping("/addRole")
    public ModelAndView addRoleHtml() {
        System.out.println("进入新增管理页面");
        String result = roleFegin.addRoleHtml();
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.setViewName("addRole");
        return modelAndView;
    }

    /**
     * 添加用户
     *
     * @param role
     * @param result
     * @return
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ModelAndView addRole(@Valid Role role, BindingResult result) {
        System.out.println("进入角色新增方法");
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.addObject("message", result.getFieldError().getDefaultMessage());
            modelAndView.addObject("role", role);
            return modelAndView;
        }
        String jieGuo = roleFegin.addRole(role);
        CommonResult commonResult = JSON.parseObject(jieGuo, CommonResult.class);
        modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.setViewName("addRole");
        return modelAndView;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @GetMapping("/roleDelete/{id}")
    @ResponseBody
    public String deleteRole(@PathVariable Integer id) {
        System.out.println("进入角色删除方法");
        return roleFegin.deleteRole(id);

    }

    //进入添加用户界面
    @GetMapping("/editRole")
    public ModelAndView editRoleHtml(Integer id) {
        System.out.println("进入添加角色界面");
        String result = roleFegin.editRoleHtml(id);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.setViewName("addRole");
        return modelAndView;
    }

    /**
     * 编辑用户
     *
     * @param role
     * @param result
     * @return
     */
    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    public ModelAndView editRole(@Valid Role role, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("进入角色编辑方法");
        if (result.hasErrors()) {
            modelAndView.addObject("error", result.getFieldError().getDefaultMessage());
            modelAndView.addObject("role", role);
            modelAndView.setViewName("editRole");
            return modelAndView;
        }
        modelAndView.setViewName("editRole");
        return modelAndView;
    }

    @GetMapping("/permission")
    public ModelAndView permissionHtml(Integer id) {
        if (id == null) {
            id = 0;
        }
        String result = roleFegin.permissionHtml(id);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        return modelAndView;
    }

    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public ModelAndView permission(String[] menuName, Integer id) {
        System.out.println("权限分配");
        System.out.println(menuName.length + id);
        String result = roleFegin.permission(menuName, id);
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.setViewName("permission");
        return modelAndView;
    }
}
