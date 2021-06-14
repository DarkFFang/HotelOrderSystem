package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.mapper.OrdersMapper;
import com.fang.hotel_order_system.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
