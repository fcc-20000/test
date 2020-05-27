package cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousingproducts;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingProducts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehousingProductsMapper {
    List<WarehousingProducts> getWarehousingProductsById(Integer id);

    Integer addWarehousingProducts(WarehousingProducts warehousingProducts);

    //根据入库单号删除
    Integer deleteWarehousingProductsByWid(Integer wid);

    //根据Id删除
    Integer deleteWarehousingProductsByid(Integer id);

    Integer updateWarehousingProducts(WarehousingProducts warehousingProducts);



}
