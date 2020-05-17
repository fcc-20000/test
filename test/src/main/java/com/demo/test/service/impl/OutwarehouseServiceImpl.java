package com.demo.test.service.impl;

import com.demo.test.entity.Outwarehouse;
import com.demo.test.dao.OutwarehouseDao;
import com.demo.test.service.OutwarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Outwarehouse)表服务实现类
 *
 * @author makejava
 * @since 2020-05-16 17:03:37
 */
@Service("outwarehouseService")
public class OutwarehouseServiceImpl implements OutwarehouseService {
    @Resource
    private OutwarehouseDao outwarehouseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Outwarehouse queryById(Integer id) {
        return this.outwarehouseDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Outwarehouse> queryAllByLimit(int offset, int limit) {
        return this.outwarehouseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param outwarehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Outwarehouse insert(Outwarehouse outwarehouse) {
        this.outwarehouseDao.insert(outwarehouse);
        return outwarehouse;
    }

    /**
     * 修改数据
     *
     * @param outwarehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Outwarehouse update(Outwarehouse outwarehouse) {
        this.outwarehouseDao.update(outwarehouse);
        return this.queryById(outwarehouse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.outwarehouseDao.deleteById(id) > 0;
    }
}