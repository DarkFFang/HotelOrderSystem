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


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-14
 */
@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Country country = countryService.getById(id);
        return JsonResponse.success(country);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        countryService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("/{id}")
    public JsonResponse updateCountry(@PathVariable("id") Integer id, Country country) throws Exception {
        country.setCountryId(id);
        countryService.updateById(country);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Country
     */
    @PostMapping("")
    public JsonResponse create(Country country) throws Exception {
        countryService.save(country);
        return JsonResponse.success(null);
    }
}

