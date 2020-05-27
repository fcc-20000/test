package cn.bdqn.warehousemanager.warehouse.service.product;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Product;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getProductAll() {
        return productMapper.getProductAll();
    }
}
