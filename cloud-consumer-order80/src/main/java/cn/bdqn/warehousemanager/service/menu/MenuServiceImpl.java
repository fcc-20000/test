package cn.bdqn.warehousemanager.service.menu;

import cn.bdqn.warehousemanager.communal.entity.Menu;
import cn.bdqn.warehousemanager.communal.mapper.menu.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return menuMapper.getAllMenus();
    }
}
