package cn.bdqn.warehousemanager.service.departement;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.util.CommonResult;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Component
public class DepartmentServiceFallback implements DepartmentService {
    @Override
    public String deptIndexHtml(Department department) {
        return "连接超时，请重试";
    }

    @Override
    public String deletUserById(Integer id) {
        return null;
    }

    @Override
    public String addDepartmentHtml() {
        return null;
    }

    @Override
    public String addRole( Department department) {
        return null;
    }
}
