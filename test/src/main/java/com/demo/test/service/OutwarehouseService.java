package com.demo.test.service;

import com.demo.test.entity.Outwarehouse;
import java.util.List;

/**
 * (Outwarehouse)表服务接口
 *
 * @author makejava
 * @since 2020-05-16 17:03:37
 */
public interface OutwarehouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Outwarehouse queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Outwarehouse> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param outwarehouse 实例对象
     * @return 实例对象
     */
    Outwarehouse insert(Outwarehouse outwarehouse);

    /**
     * 修改数据
     *
     * @param outwarehouse 实例对象
     * @return 实例对象
     */
    Outwarehouse update(Outwarehouse outwarehouse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}