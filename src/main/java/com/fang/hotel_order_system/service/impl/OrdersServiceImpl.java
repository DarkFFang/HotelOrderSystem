package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.entity.vo.OrdersVo;
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
    public List<OrdersVo> listOrdersVo() {
        return baseMapper.selectOrdersVoList();
    }

    @Override
    public IPage<OrdersVo> pageOrdersVo(Page<OrdersVo> page) {
        return baseMapper.selectOrdersVoPage(page);
    }

    @Override
    public IPage<OrdersVo> pageOrdersVo(Page<OrdersVo> page, Wrapper wrapper) {
        return baseMapper.selectOrdersVoPageByWrapper(page, wrapper);
    }
}
