package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.CountryService;
import com.fang.hotel_order_system.entity.Country;

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
@RequestMapping("/api/country")
public class CountryController {

    private final Logger logger = LoggerFactory.getLogger( CountryController.class );

    @Autowired
    private CountryService countryService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Country> countryList =  countryService.list();
        return JsonResponse.success(countryList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Country country =  countryService.getById(id);
        return JsonResponse.success(country);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(countryService.removeById(id)){
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
    public JsonResponse updateByIdCountry(Country  country) throws Exception {
        if(countryService.updateById(country)){
            return JsonResponse.success(country, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Country
    *
    */
    @PostMapping("")
    public JsonResponse create(Country  country) throws Exception {
        if(countryService.save(country)){
            return JsonResponse.success(country, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

