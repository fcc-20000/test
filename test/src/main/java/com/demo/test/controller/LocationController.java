package com.demo.test.controller;

import com.demo.test.entity.Location;
import com.demo.test.service.LocationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Location)表控制层
 *
 * @author makejava
 * @since 2020-05-16 16:46:17
 */
@RestController
@RequestMapping("location")
public class LocationController {
    /**
     * 服务对象
     */
    @Resource
    private LocationService locationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Location selectOne(Integer id) {
        return this.locationService.queryById(id);
    }

}