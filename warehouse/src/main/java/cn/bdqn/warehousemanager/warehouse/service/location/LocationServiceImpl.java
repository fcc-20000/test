package cn.bdqn.warehousemanager.warehouse.service.location;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Location;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.location.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationMapper locationMapper;

    @Override
    public List<Location> getLocationAll() {
        return locationMapper.getLocationAll();
    }
}
