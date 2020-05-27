package cn.bdqn.warehousemanager.warehousehome.controller;

import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.warehousehome.service.menu.MenuService;
import cn.bdqn.warehousemanager.warehousehome.service.role.RoleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    //进入角色管理表
    @PostMapping("/roleIndex")
    public String roleIndex(@RequestBody Role role) {
        System.out.println("进入角色管理页面");
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.getRolesAllByName(role);
        modelAndView.addObject("roles", roles);
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    /**
     * 进入添加用户界面
     *
     * @return
     */
    @GetMapping("/addRole")
    public ModelAndView addRoleHtml() {
        System.out.println("进入新增管理页面");
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role();
        modelAndView.addObject("role", role);
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
    public ModelAndView addRole(@Valid Role role) {
        System.out.println("进入角色新增方法");
        ModelAndView modelAndView = new ModelAndView();

        Integer reuslt = roleService.addRole(role);
        if (reuslt > 0) {
            List<Role> roles = roleService.getRolesAllByName(new Role());
            modelAndView.addObject("roles", roles);
            modelAndView.setViewName("roleIndex");
            modelAndView.addObject("message", "添加用户成功！");
            return modelAndView;
        }

        modelAndView.addObject("message", "添加用户失败！");
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
        String prompt;
        List<String> list = new ArrayList<>();
        Integer reuslt = roleService.deleteUserRoleByid(id);
        if (reuslt > 0) {
            prompt = "删除成功！";
        } else {
            prompt = "删除失败！";
        }
        list.add(prompt);
        return JSON.toJSONString(list);
    }

    //进入添加用户界面
    @GetMapping("/editRole")
    public ModelAndView editRoleHtml(Integer id) {
        System.out.println("进入添加角色界面");
        Role role = new Role();
        role.setId(id);
        List<Role> list = roleService.getRolesAllByName(role);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles", list);
        modelAndView.setViewName("editRole");
        return modelAndView;
    }

    /**
     * 编辑用户
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    public ModelAndView editRole(@Valid Role role) {
        System.out.println("进入角色编辑方法");
        ModelAndView modelAndView = new ModelAndView();

        Integer reuslt = roleService.updateRole(role);
        if (reuslt > 0) {
            List<Role> roles = roleService.getRolesAllByName(new Role());
            modelAndView.addObject("roles", roles);
            modelAndView.setViewName("roleIndex");
            modelAndView.addObject("message", "编辑用户成功！");
            return modelAndView;
        }

        modelAndView.addObject("message", "编辑用户失败！");
        return modelAndView;
    }

    @GetMapping("/permissionHtml")
    public String permissionHtml(Integer id) {
        if (id == null) {
            id = 0;
        }
        System.out.println("进入权限分配页面");
        ModelAndView modelAndView = new ModelAndView();
        List<Menu> list = menuService.getAllMenus();
        System.out.println(JSON.toJSONString(list));
        List<Role> roleList = roleService.getRolesAll();
        modelAndView.addObject("menus", list);
        modelAndView.addObject("rId", id);
        modelAndView.addObject("roles", roleList);
        modelAndView.setViewName("permission");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public String permission(String[] menuName, Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(menuName.length + id);
        Integer result = menuService.addRoleMenu(menuName, id);
        System.out.println("权限分配");
        List<Menu> list = menuService.getAllMenus();
        List<Role> roleList = roleService.getRolesAll();
        modelAndView.addObject("menus", list);
        modelAndView.addObject("roles", roleList);
        if (result > 0) {

            CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
            return JSON.toJSONString(commonResult);

        }
        modelAndView.addObject("error", "权限分配出现异常，请联系管理员");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }
}
