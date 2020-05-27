package cn.bdqn.warehousemanager.warehouse.service.warehousingproducts;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Warehousing;
import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousingproducts.WarehousingProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousingproductsServiceImpl implements WarehousingproductsService {
    @Autowired
    WarehousingProductsMapper warehousingProductsMapper;

    @Override
    public List<WarehousingProducts> getWarehousingProductsById(Integer id) {
        return warehousingProductsMapper.getWarehousingProductsById(id);
    }


    public Integer addWarehousingProducts(WarehousingProducts warehousingProducts) {
        return warehousingProductsMapper.addWarehousingProducts(warehousingProducts);
    }


    @Override
    public Integer deleteWarehousingProductsByWid(Integer wId) {
        return warehousingProductsMapper.deleteWarehousingProductsByWid(wId);
    }

    @Override
    public Integer deleteWarehousingProductsByid(Integer id) {
        return warehousingProductsMapper.deleteWarehousingProductsByid(id);
    }

    @Override
    public Integer updateWarehousingProducts(WarehousingProducts warehousingProducts) {
        return warehousingProductsMapper.updateWarehousingProducts(warehousingProducts);
    }
}
