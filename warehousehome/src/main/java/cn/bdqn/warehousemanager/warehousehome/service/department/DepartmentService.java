package cn.bdqn.warehousemanager.warehousehome.service.department;

import cn.bdqn.warehousemanager.communal.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartmentAll(Department department);

    Integer deleteDepartment(Integer id);

    Integer updateDepartment(Department department);

    Integer addDepartment(Department department);
}
