package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.CityService;
import com.fang.hotel_order_system.entity.City;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-14
 */
@RestController
@RequestMapping("/api/city")
public class CityController {

    private final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        City city = cityService.getById(id);
        return JsonResponse.success(city);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        cityService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("/{id}")
    public JsonResponse updateCity(@PathVariable("id") Long id, City city) throws Exception {
        city.setCityId(id);
        cityService.updateById(city);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建City
     */
    @PostMapping("")
    public JsonResponse create(City city) throws Exception {
        cityService.save(city);
        return JsonResponse.success(null);
    }
}

