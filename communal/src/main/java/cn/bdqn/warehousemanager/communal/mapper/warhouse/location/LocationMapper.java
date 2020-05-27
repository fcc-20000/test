package cn.bdqn.warehousemanager.communal.mapper.warhouse.location;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    List<Location> getLocationAll();
}
