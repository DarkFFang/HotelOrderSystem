package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Hotel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.HotelVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface HotelService extends IService<Hotel> {
    List<HotelVo> listHotelVo();

    IPage<HotelVo> pageHotelVo(Page<HotelVo> page);

    IPage<HotelVo> pageHotelVo(Page<HotelVo> page, Wrapper wrapper);
}
