package cn.bdqn.warehousemanager.warehousehome.service.role;

import cn.bdqn.warehousemanager.communal.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesAll();

    Integer addUserRole(Integer rid, Integer uid);

    Integer addRole(Role role);

    Integer deleteUserRoleByuId(Integer uid);

    List<Role> getRolesAllByName(Role role);

    Integer updateRole(Role role);

    Integer deleteUserRoleByid(Integer id);
}
