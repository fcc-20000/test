package cn.bdqn.warehousemanager.warehouse.service.warehousingtype;

import cn.bdqn.warehousemanager.communal.entity.warhouse.WarehousingType;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.warehousingtype.WarehousingTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousingTypeServiceImpl implements WarehousingTypeService {
    @Autowired
    WarehousingTypeMapper warehousingTypeMapper;

    @Override
    public List<WarehousingType> getWarehousingTypeAll() {
        return warehousingTypeMapper.getWarehousingTypeAll();
    }

    @Override
    public List<WarehousingType> getOutWarehousingTypeAll() {
        return warehousingTypeMapper.getOutWarehousingTypeAll();
    }
}
