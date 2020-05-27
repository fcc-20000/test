package cn.bdqn.warehousemanager.warehousehome.service.menu;

import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.mapper.menu.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public Integer deleteMenuByRid(Integer rId) {
        return menuMapper.deleteMenuByRid(rId);
    }

    public Integer addRoleMenu(String[] mids, Integer rId) {
        menuMapper.deleteMenuByRid(rId);
        Integer result = 0;
        for (String mid : mids) {
            result = menuMapper.addRoleMenu(Integer.parseInt(mid), rId);
        }
        return result;
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> list = menuMapper.getAllMenus();
        List<Menu> menus = new ArrayList<>();
        for (Menu menu : list) {
            List<Menu> list1 = menuMapper.getMenusByparentId(menu.getId());
            menu.setMenus(list1);
            menus.add(menu);
        }
        return menus;
    }
}
