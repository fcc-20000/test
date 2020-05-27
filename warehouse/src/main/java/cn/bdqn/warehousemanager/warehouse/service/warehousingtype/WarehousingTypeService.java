package cn.bdqn.warehousemanager.warehouse.service.warehousingtype;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingType;

import java.util.List;

public interface WarehousingTypeService {
    List<WarehousingType> getWarehousingTypeAll();
    List<WarehousingType> getOutWarehousingTypeAll();
}
