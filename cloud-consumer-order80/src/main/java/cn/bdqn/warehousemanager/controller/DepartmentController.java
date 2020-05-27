package cn.bdqn.warehousemanager.controller;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import cn.bdqn.warehousemanager.service.departement.DepartmentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/deptIndex")
    public ModelAndView deptIndexHtml(Department department) {
        String result = departmentService.deptIndexHtml(department);
        if (department == null) {
            department = new Department();
        }
        System.out.println(department.getDepartmentName());
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        modelAndView.addObject("department", department);
        return modelAndView;
    }

    @GetMapping("/deleteDepartment/{id}")
    @ResponseBody
    public String deletUserById(@PathVariable Integer id) {
        System.out.println("进入用户删除方法");
        String result = departmentService.deletUserById(id);
        return result;
    }


    /**
     * 进入添加用户界面
     *
     * @return
     */
    @GetMapping("/addDepartment")
    public ModelAndView addDepartmentHtml() {
        System.out.println("进入新增部门页面");
        String result = departmentService.addDepartmentHtml();
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(result, CommonResult.class);
        ModelAndView modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        return modelAndView;
    }

    /**
     * 添加部门
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public ModelAndView addRole(@Valid Department department, BindingResult result) {
        System.out.println("进入部门新增方法");
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.addObject("error", result.getFieldError().getDefaultMessage());
            modelAndView.addObject("department", department);
            modelAndView.setViewName("addDepartment");
            return modelAndView;
        }
        String jieGuo = departmentService.addDepartmentHtml();
        System.out.println(result);
        CommonResult commonResult = JSON.parseObject(jieGuo, CommonResult.class);
         modelAndView = JSON.parseObject(commonResult.getData().toString(), ModelAndView.class);
        return modelAndView;

    }
}
