package cn.bdqn.warehousemanager.warehousehome.service.role;

import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.mapper.role.RoleMapper;
import cn.bdqn.warehousemanager.warehousehome.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    MenuService menuService;

    @Override
    public List<Role> getRolesAll() {
        return roleMapper.getRolesAll();
    }

    @Override
    public Integer addUserRole(Integer rid, Integer uid) {
        return roleMapper.addUserRole(rid, uid);
    }

    @Override
    public Integer addRole(Role role) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        role.setCreationTime(sf.format(new Date()));
        return roleMapper.addRole(role);
    }

    @Override
    public Integer deleteUserRoleByuId(Integer uid) {
        return roleMapper.deleteUserRoleByuId(uid);
    }

    @Override
    public List<Role> getRolesAllByName(Role role) {
        return roleMapper.getRolesAllByName(role);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public Integer deleteUserRoleByid(Integer id) {
        roleMapper.deleteUserRoleUserByid(id);//删除用户表iao
        menuService.deleteMenuByRid(id);//删除权限表
        return roleMapper.deleteUserRoleByid(id);
    }
}
