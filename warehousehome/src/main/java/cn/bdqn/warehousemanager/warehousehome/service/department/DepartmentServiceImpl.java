package cn.bdqn.warehousemanager.warehousehome.service.department;

import cn.bdqn.warehousemanager.communal.entity.Department;
import cn.bdqn.warehousemanager.communal.mapper.department.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<Department> getDepartmentAll(Department department) {
        return departmentMapper.getDepartmentAll(department);
    }

    @Override
    public Integer deleteDepartment(Integer id) {
        return departmentMapper.deleteDepartment(id);
    }

    @Override
    public Integer updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public Integer addDepartment(Department department) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        department.setCreationTime(sf.format(new Date()));
        return departmentMapper.addDepartment(department);
    }
}
