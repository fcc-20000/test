package cn.bdqn.warehousemanager.warehouse.service.warehousing;

import cn.bdqn.warehousemanager.communal.entity.vo.UpdateWarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingProductsVo;
import cn.bdqn.warehousemanager.communal.entity.vo.WarehousingVo;
import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;

import java.util.List;

public interface WarehousingService {
    List<WarehousingVo> getAllWarehousing(WarehousingVo warehousing);

    int getAllWarehousingCount(WarehousingVo warehousing);

    WarehousingVo getWarehousingVoById(Integer id);

    Integer addWarehousing(WarehousingProductsVo warehousingProductsVo);

    Integer deleteWarehousingById(Integer id);

    Integer updateWarehousing(UpdateWarehousingVo updateWarehousingVo);

    Integer updateReview(Integer id, String name,Integer aid);
}
