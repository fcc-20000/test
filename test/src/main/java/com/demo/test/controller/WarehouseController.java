package com.demo.test.controller;

import com.demo.test.entity.Warehouse;
import com.demo.test.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Warehouse)表控制层
 *
 * @author makejava
 * @since 2020-05-16 17:17:38
 */
@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private WarehouseService warehouseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Warehouse selectOne(Integer id) {
        return this.warehouseService.queryById(id);
    }

}