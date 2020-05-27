package cn.bdqn.warehousemanager.warehousehome.controller;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.warehousehome.service.department.DepartmentService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //    @GetMapping("/deptIndex")
//    @RequestMapping(value = "/deptIndex", method = RequestMethod.GET)
    @PostMapping("/deptIndex")
    public String deptIndexHtml(@RequestBody Department department) {
        System.out.println(department.getDepartmentName());
        ModelAndView modelAndView = new ModelAndView();
        List<Department> departments = departmentService.getDepartmentAll(department);
        modelAndView.addObject("departments", departments);
        modelAndView.setViewName("deptIndex");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deletUserById(@PathVariable Integer id) {
        System.out.println("进入用户删除方法");
        String prompt;
        Integer result = departmentService.deleteDepartment(id);
        List<String> list = new ArrayList<>();
        if (result > 0) {
            prompt = "删除成功";

        } else {
            prompt = "删除失败";
        }
        list.add(prompt);
        return JSON.toJSONString(list);
    }


    /**
     * 进入添加用户界面
     *
     * @return
     */
    @GetMapping("/addDepartment")
    public String addDepartmentHtml() {
        System.out.println("进入新增部门页面");
        ModelAndView modelAndView = new ModelAndView();
        Department department = new Department();
        modelAndView.addObject("role", department);
        modelAndView.setViewName("addDepartment");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);
    }

    /**
     * 添加部门
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public String addRole(@RequestBody Department department) {
        System.out.println("进入部门新增方法");
        ModelAndView modelAndView = new ModelAndView();

        Integer reuslt = departmentService.addDepartment(department);
        if (reuslt > 0) {
            List<Department> departments = departmentService.getDepartmentAll(department);
            modelAndView.addObject("departments", departments);
            modelAndView.addObject("department", department);
            modelAndView.addObject("verification", "添加部门成功！");
            CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
            return JSON.toJSONString(commonResult);
        }
        modelAndView.setViewName("addDepartment");
        modelAndView.addObject("verification", "添加部门失败！");
        CommonResult<ModelAndView> commonResult = new CommonResult<ModelAndView>(200, "message", modelAndView);
        return JSON.toJSONString(commonResult);

    }
}
