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

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-17
 * @version v1.0
 */
@RestController
@RequestMapping("/api/city")
public class CityController {

    private final Logger logger = LoggerFactory.getLogger( CityController.class );

    @Autowired
    private CityService cityService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<City> cityList =  cityService.list();
        return JsonResponse.success(cityList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        City city =  cityService.getById(id);
        return JsonResponse.success(city);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(cityService.removeById(id)){
            return JsonResponse.successMessage("删除成功！");
        }else{
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("")
    public JsonResponse updateByIdCity(City  city) throws Exception {
        if(cityService.updateById(city)){
            return JsonResponse.success(city, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建City
    *
    */
    @PostMapping("")
    public JsonResponse create(City  city) throws Exception {
        if(cityService.save(city)){
            return JsonResponse.success(city, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

