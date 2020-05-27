package cn.bdqn.warehousemanager.communal.mapper.warhouse.outwarehouse;

import cn.bdqn.warehousemanager.communal.entity.vo.OutWarehouseVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.OutWarehouse;
import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutWarehouseMapper {
    List<OutWarehouseVo> getAllWarehousing(OutWarehouseVo warehousing);

    Integer getAllWarehousingCount(OutWarehouseVo warehousing);

    OutWarehouseVo getWarehousingVoById(Integer id);

    Integer addWarehousing(OutWarehouse warehousing);

    Integer deleteWarehousingById(Integer id);

    Integer updateWarehousing(OutWarehouse warehousing);

    Integer updateReview(OutWarehouse outWarehouse);
}
