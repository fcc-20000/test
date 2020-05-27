package cn.bdqn.warehousemanager.communal.mapper.menu;

import cn.bdqn.warehousemanager.communal.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();

    Integer deleteMenuByRid(Integer rId);

    Integer addRoleMenu(@Param("mid") Integer mid, @Param("rid") Integer rid);

    List<Menu> getMenusById(Integer id);

    List<Menu> getMenusByparentId(Integer parentId);
}
