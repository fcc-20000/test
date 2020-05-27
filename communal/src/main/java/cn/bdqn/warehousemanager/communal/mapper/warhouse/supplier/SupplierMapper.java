package cn.bdqn.warehousemanager.communal.mapper.warhouse.supplier;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {

    List<Supplier> getSupplierAll();
}
