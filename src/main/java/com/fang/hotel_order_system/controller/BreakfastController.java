package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.BreakfastService;
import com.fang.hotel_order_system.entity.Breakfast;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-14
 */
@RestController
@RequestMapping("/api/breakfast")
public class BreakfastController {

    private final Logger logger = LoggerFactory.getLogger(BreakfastController.class);

    @Autowired
    private BreakfastService breakfastService;

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Breakfast breakfast = breakfastService.getById(id);
        return JsonResponse.success(breakfast);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        breakfastService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("/{id}")
    public JsonResponse updateBreakfast(@PathVariable("id") Long id, Breakfast breakfast) throws Exception {
        breakfast.setBreakfastId(id);
        breakfastService.updateById(breakfast);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Breakfast
     */
    @PostMapping("")
    public JsonResponse create(Breakfast breakfast) throws Exception {
        breakfastService.save(breakfast);
        return JsonResponse.success(null);
    }
}

