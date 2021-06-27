package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.OrdersVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface OrdersService extends IService<Orders> {
    List<OrdersVo> listOrdersVo();

    IPage<OrdersVo> pageOrdersVo(Page<OrdersVo> page);

    IPage<OrdersVo> pageOrdersVo(Page<OrdersVo> page, Wrapper wrapper);
}
