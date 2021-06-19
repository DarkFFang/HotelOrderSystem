package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.OrdersService;
import com.fang.hotel_order_system.entity.Orders;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-18
 * @version v1.0
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private OrdersService ordersService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Orders> ordersList =  ordersService.list();
        return JsonResponse.success(ordersList);
    }

    /**
    * 描述：查询整个列表,并分页
    *
    */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current,@PathVariable long size)throws Exception {
        Page<Orders> page=new Page<>(current,size);
        ordersService.page(page);
        return JsonResponse.success(page);
    }

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Orders orders =  ordersService.getById(id);
        return JsonResponse.success(orders);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(ordersService.removeById(id)){
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
    public JsonResponse updateByOrdersId(Orders  orders) throws Exception {
        if(ordersService.updateById(orders)){
            return JsonResponse.success(orders, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Orders
    *
    */
    @PostMapping("")
    public JsonResponse create(Orders  orders) throws Exception {
        if(ordersService.save(orders)){
            return JsonResponse.success(orders, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

