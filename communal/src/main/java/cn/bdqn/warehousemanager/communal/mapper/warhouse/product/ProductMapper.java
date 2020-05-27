package cn.bdqn.warehousemanager.communal.mapper.warhouse.product;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> getProductAll();
}
