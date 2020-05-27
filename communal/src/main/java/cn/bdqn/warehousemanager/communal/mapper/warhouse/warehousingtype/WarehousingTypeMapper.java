package cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousingtype;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WarehousingTypeMapper {

    List<WarehousingType> getWarehousingTypeAll();

    List<WarehousingType> getOutWarehousingTypeAll();
}
