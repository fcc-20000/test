package cn.bdqn.warehousemanager.service.role;

import cn.bdqn.warehousemanager.communal.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@FeignClient(value = "WAREHOUSEHOME")
public interface RoleFegin {
    @PostMapping("/api/user/roleIndex")
    public String roleIndex(@RequestBody Role role);

    @GetMapping("/api/user/addRole")
    public String addRoleHtml();

    @RequestMapping(value = "/api/user/addRole", method = RequestMethod.POST)
    public String addRole(Role role);

    @GetMapping("/api/user/roleDelete/{id}")
    public String deleteRole(@PathVariable Integer id);

    @GetMapping("/api/user/editRole")
    public String editRoleHtml(Integer id);

    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    public String editRole(@RequestBody Role role);

    @GetMapping("/api/user/permissionHtml")
    public String permissionHtml(@RequestParam("id") Integer id);

    @RequestMapping(value = "/api/user/permission", method = RequestMethod.GET)
    public String permission(@RequestParam("menuName") String[] menuName,@RequestParam("id")  Integer id);
}
