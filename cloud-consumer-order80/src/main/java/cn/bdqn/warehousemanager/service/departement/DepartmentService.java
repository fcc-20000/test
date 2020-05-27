package cn.bdqn.warehousemanager.service.departement;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//, fallback = DepartmentServiceFallback.class
@FeignClient(value = "WAREHOUSEHOME")
public interface DepartmentService {

    @PostMapping("/api/user/deptIndex")
    public String deptIndexHtml(@RequestBody Department department);

    @GetMapping("/api/user/deleteDepartment/{id}")
    public String deletUserById(@PathVariable(value = "id") Integer id);

    @GetMapping("/api/user/addDepartment")
    public String addDepartmentHtml();

    @RequestMapping(value = "/api/user/addDepartment", method = RequestMethod.POST)
    public String addRole( @RequestBody Department department);
}
