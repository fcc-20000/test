package com.demo.test.service.impl;

import com.demo.test.entity.Location;
import com.demo.test.dao.LocationDao;
import com.demo.test.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Location)表服务实现类
 *
 * @author makejava
 * @since 2020-05-16 16:46:16
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationDao locationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Location queryById(Integer id) {
        return this.locationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Location> queryAllByLimit(int offset, int limit) {
        return this.locationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location insert(Location location) {
        this.locationDao.insert(location);
        return location;
    }

    /**
     * 修改数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location update(Location location) {
        this.locationDao.update(location);
        return this.queryById(location.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.locationDao.deleteById(id) > 0;
    }
}