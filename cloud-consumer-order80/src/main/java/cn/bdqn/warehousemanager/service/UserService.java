package cn.bdqn.warehousemanager.service;


import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.mapper.menu.MenuMapper;
import cn.bdqn.warehousemanager.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cn.bdqn.warehousemanager.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUserName(userName);
        List<Menu> menus = new ArrayList<>();
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在！");
        }
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        for (Role role : user.getRoles()) {
            menus = menuMapper.getMenusById(role.getId());
        }
        user.setMenus(menus);
        return user;
    }

}
