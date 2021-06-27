package com.fang.hotel_order_system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Hotel;
import com.fang.hotel_order_system.entity.vo.HotelVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Component
public interface HotelMapper extends BaseMapper<Hotel> {
    List<HotelVo> selectHotelVoList();

    IPage<HotelVo> selectHotelVoPage(Page<HotelVo> page);

    IPage<HotelVo> selectHotelVoPageByWrapper(Page<HotelVo> page, Wrapper ew);


}
