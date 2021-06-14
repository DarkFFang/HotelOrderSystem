package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.OrdersService;
import com.fang.hotel_order_system.entity.Orders;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-14
 * @version v1.0
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger( OrdersController.class );

    @Autowired
    private OrdersService ordersService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Orders  orders =  ordersService.getById(id);
        return JsonResponse.success(orders);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        ordersService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updateOrders(@PathVariable("id") Long  id,Orders  orders) throws Exception {
        orders.setOrdersId(id);
        ordersService.updateById(orders);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Orders
    *
    */
    @PostMapping("")
    public JsonResponse create(Orders  orders) throws Exception {
        ordersService.save(orders);
        return JsonResponse.success(null);
    }
}

