package cn.bdqn.warehousemanager.communal.mapper.role;

import cn.bdqn.warehousemanager.communal.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRolesAll();

    Integer addUserRole(@Param("rid") Integer rid,@Param("uid") Integer uid);

    Integer addRole(Role role);

    Integer deleteUserRoleByuId(Integer uid);

    List<Role> getRolesAllByName(Role role);

    Integer updateRole(Role role);

    Integer deleteUserRoleByid(Integer id);

    Integer deleteUserRoleUserByid(Integer rid);

}
