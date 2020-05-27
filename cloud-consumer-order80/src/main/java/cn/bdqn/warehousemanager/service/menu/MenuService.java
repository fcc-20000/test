package cn.bdqn.warehousemanager.service.menu;

import cn.bdqn.warehousemanager.communal.entity.Menu;

import java.util.List;

public interface MenuService {
    Integer deleteMenuByRid(Integer rId);

    Integer addRoleMenu(String[] mids, Integer rId);

    List<Menu> getAllMenus();
}
