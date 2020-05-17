package com.demo.test.dao;

import com.demo.test.entity.Location;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Location)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-16 16:46:14
 */
public interface LocationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Location queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Location> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param location 实例对象
     * @return 对象列表
     */
    List<Location> queryAll(Location location);

    /**
     * 新增数据
     *
     * @param location 实例对象
     * @return 影响行数
     */
    int insert(Location location);

    /**
     * 修改数据
     *
     * @param location 实例对象
     * @return 影响行数
     */
    int update(Location location);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}