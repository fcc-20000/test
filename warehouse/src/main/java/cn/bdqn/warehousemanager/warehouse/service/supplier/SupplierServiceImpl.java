package cn.bdqn.warehousemanager.warehouse.service.supplier;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Supplier;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.supplier.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getSupplierAll() {
        return supplierMapper.getSupplierAll();
    }
}
