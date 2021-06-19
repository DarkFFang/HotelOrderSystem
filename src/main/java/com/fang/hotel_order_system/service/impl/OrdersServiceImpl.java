package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.mapper.OrdersMapper;
import com.fang.hotel_order_system.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Override
    public IPage<Orders> pageByUserId(Page<Orders> page, Long userId) {
        return baseMapper.selectPageByUserId(page, userId);
    }

    @Override
    public List<Orders> listByUserId(Long userId) {
        return baseMapper.selectListByUserId(userId);
    }
}
