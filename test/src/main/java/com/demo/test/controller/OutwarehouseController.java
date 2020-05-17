package com.demo.test.controller;

import com.demo.test.entity.Outwarehouse;
import com.demo.test.service.OutwarehouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Outwarehouse)表控制层
 *
 * @author makejava
 * @since 2020-05-16 17:03:37
 */
@RestController
@RequestMapping("outwarehouse")
public class OutwarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private OutwarehouseService outwarehouseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Outwarehouse selectOne(Integer id) {
        return this.outwarehouseService.queryById(id);
    }

}