package cn.bdqn.warehousemanager.communal.mapper.department;

import cn.bdqn.warehousemanager.communal.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<Department> getDepartmentAll(Department department);

    Integer deleteDepartment(Integer id);

    Integer updateDepartment(Department department);

    Integer addDepartment(Department department);
}
