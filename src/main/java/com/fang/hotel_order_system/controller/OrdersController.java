package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Room;
import com.fang.hotel_order_system.entity.vo.OrdersVo;
import com.fang.hotel_order_system.service.RoomService;
import org.springframework.transaction.annotation.Transactional;
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
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private RoomService roomService;

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<Orders> ordersList = ordersService.list();
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Orders> page = new Page<>(current, size);
        ordersService.page(page);
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询相关用户的整个列表
     */
    @GetMapping("/userId/{userId}")
    public JsonResponse getListByUserId(@PathVariable Long userId) throws Exception {
        List<Orders> ordersList = ordersService.list(new QueryWrapper<Orders>().eq("user_id",userId));
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("/userId/{userId}/page/{current}/{size}")
    public JsonResponse getListPageByUserId(@PathVariable Long userId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Orders> page = new Page<>(current, size);
        ordersService.page(page, new QueryWrapper<Orders>().eq("user_id",userId));
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询相关酒店的整个列表
     */
    @GetMapping("/hotelId/{hotelId}")
    public JsonResponse getListByHotelId(@PathVariable Long hotelId) throws Exception {
        List<Orders> ordersList = ordersService.list(new QueryWrapper<Orders>().eq("hotel_id",hotelId));
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询相关酒店的列表,并分页
     */
    @GetMapping("/hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getListPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Orders> page = new Page<>(current, size);
        ordersService.page(page, new QueryWrapper<Orders>().eq("hotel_id",hotelId));
        return JsonResponse.success(page);
    }
    /**
     * 描述：查询整个列表
     */
    @GetMapping("/ordersVo")
    public JsonResponse getOrdersVoList() throws Exception {
        List<OrdersVo> ordersList = ordersService.listOrdersVo();
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/ordersVo/page/{current}/{size}")
    public JsonResponse getOrdersVoListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Orders> page = new Page<>(current, size);
        ordersService.page(page);
        return JsonResponse.success(page);
    }

//    /**
//     * 描述：查询相关用户的整个列表
//     */
//    @GetMapping("/ordersVo/userId/{userId}")
//    public JsonResponse getOrdersVoListByUserId(@PathVariable Long userId) throws Exception {
//        List<Orders> ordersList = ordersService.list(new QueryWrapper<Orders>().eq("user_id",userId));
//        return JsonResponse.success(ordersList);
//    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("/ordersVo/userId/{userId}/page/{current}/{size}")
    public JsonResponse getOrdersVoPageByUserId(@PathVariable Long userId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<OrdersVo> page = new Page<>(current, size);
        ordersService.pageOrdersVo(page, new QueryWrapper<OrdersVo>().eq("user_id",userId));
        return JsonResponse.success(page);
    }

//    /**
//     * 描述：查询相关酒店的整个列表
//     */
//    @GetMapping("/ordersVo/hotelId/{hotelId}")
//    public JsonResponse getOrdersVoListByHotelId(@PathVariable Long hotelId) throws Exception {
//        List<Orders> ordersList = ordersService.list(new QueryWrapper<Orders>().eq("hotel_id",hotelId));
//        return JsonResponse.success(ordersList);
//    }

    /**
     * 描述：查询相关酒店的列表,并分页
     */
    @GetMapping("/ordersVo/hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getOrdersVoPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<OrdersVo> page = new Page<>(current, size);
        ordersService.pageOrdersVo(page, new QueryWrapper<OrdersVo>().eq("o.hotel_id",hotelId));
        return JsonResponse.success(page);
    }
    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Orders orders = ordersService.getById(id);
        return JsonResponse.success(orders);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if (ordersService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByOrdersId(@RequestBody Orders orders) throws Exception {
        if (ordersService.updateById(orders)) {
            return JsonResponse.success(orders, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }

    /**
     * 描述：根据Id 更新
     */
    @PutMapping("cancel/{ordersId}")
    @Transactional
    public JsonResponse cancelOrdersByOrdersId(@PathVariable Long ordersId) throws Exception {
        Orders orders = ordersService.getById(ordersId);
        if (orders.getStatusId() != 1) {
            return JsonResponse.failure("该订单不可取消！");
        }
        orders.setStatusId(3);
        if (ordersService.updateById(orders)) {
            Room room = roomService.getOne(new QueryWrapper<Room>().eq("room_id", orders.getRoomId()));
            room.setRemainQuantity(room.getRemainQuantity() + orders.getQuantity());
            roomService.updateById(room);
            return JsonResponse.success(orders, "取消成功！");
        } else {
            return JsonResponse.failure("取消失败！");
        }
    }


    /**
     * 描述:创建Orders
     */
    @PostMapping("")
    @Transactional
    public JsonResponse create(@RequestBody Orders orders) throws Exception {
        Room room = roomService.getOne(new QueryWrapper<Room>().eq("room_id", orders.getRoomId()));
        if (room.getRemainQuantity() >= orders.getQuantity()) {
            room.setRemainQuantity(room.getRemainQuantity() - orders.getQuantity());
            roomService.updateById(room);
        }else {
            return JsonResponse.failure("该房间数量不足，下单失败！");
        }
        if (ordersService.save(orders)) {
            return JsonResponse.success(orders, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }


    }
}

