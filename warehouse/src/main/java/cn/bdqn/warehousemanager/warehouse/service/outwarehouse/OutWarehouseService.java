package cn.bdqn.warehousemanager.warehouse.service.outwarehouse;

import cn.bdqn.warehousemanager.communal.entity.vo.OutWarehouseVo;
import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.OutWarehouse;

import java.util.List;

public interface OutWarehouseService {
    List<OutWarehouseVo> getAllWarehousing(OutWarehouseVo outWarehouseVo);

    int getAllWarehousingCount(OutWarehouseVo outWarehouseVo);

    OutWarehouseVo getWarehousingVoById(Integer id);

    Integer addWarehousing(WarehousingProductsVo warehousingProductsVo);

    Integer deleteWarehousingById(Integer id);

    Integer updateWarehousing(UpdateWarehousingVo updateWarehousingVo);

    Integer updateReview(Integer id, String name, Integer aid);
}
