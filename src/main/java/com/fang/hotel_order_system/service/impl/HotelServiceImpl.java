package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Hotel;
import com.fang.hotel_order_system.entity.vo.HotelVo;
import com.fang.hotel_order_system.mapper.HotelMapper;
import com.fang.hotel_order_system.service.HotelService;
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
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService {

    @Override
    public List<HotelVo> listHotelVo() {
        return baseMapper.selectHotelVoList();
    }

    @Override
    public IPage<HotelVo> pageHotelVo(Page<HotelVo> page) {
        return baseMapper.selectHotelVoPage(page);
    }

    @Override
    public IPage<HotelVo> pageHotelVo(Page<HotelVo> page, Wrapper wrapper) {
        return baseMapper.selectHotelVoPageByWrapper(page, wrapper);
    }
}
