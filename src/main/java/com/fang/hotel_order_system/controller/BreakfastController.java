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
@RequestMapping("/api/breakfast")
public class BreakfastController {

    private final Logger logger = LoggerFactory.getLogger( BreakfastController.class );

    @Autowired
    private BreakfastService breakfastService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Breakfast> breakfastList =  breakfastService.list();
        return JsonResponse.success(breakfastList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Breakfast breakfast =  breakfastService.getById(id);
        return JsonResponse.success(breakfast);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(breakfastService.removeById(id)){
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
    public JsonResponse updateByIdBreakfast(Breakfast  breakfast) throws Exception {
        if(breakfastService.updateById(breakfast)){
            return JsonResponse.success(breakfast, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Breakfast
    *
    */
    @PostMapping("")
    public JsonResponse create(Breakfast  breakfast) throws Exception {
        if(breakfastService.save(breakfast)){
            return JsonResponse.success(breakfast, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

