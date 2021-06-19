package com.fang.hotel_order_system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Component
public interface OrdersMapper extends BaseMapper<Orders> {
    List<Orders> selectListByUserId(Long userId);

    IPage<Orders> selectPageByUserId(Page<Orders> page, Long userId);
}
