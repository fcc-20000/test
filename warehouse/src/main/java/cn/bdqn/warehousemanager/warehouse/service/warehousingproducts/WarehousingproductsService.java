package cn.bdqn.warehousemanager.warehouse.service.warehousingproducts;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;

import java.util.List;

public interface WarehousingproductsService {
    List<WarehousingProducts> getWarehousingProductsById(Integer id);

    Integer addWarehousingProducts(WarehousingProducts warehousingProducts);

    Integer deleteWarehousingProductsByWid(Integer wId);

    Integer deleteWarehousingProductsByid(Integer id);

    Integer updateWarehousingProducts(WarehousingProducts warehousingProducts);

}
