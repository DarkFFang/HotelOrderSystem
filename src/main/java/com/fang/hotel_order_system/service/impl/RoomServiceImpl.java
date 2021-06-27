package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Room;
import com.fang.hotel_order_system.entity.vo.RoomVo;
import com.fang.hotel_order_system.mapper.RoomMapper;
import com.fang.hotel_order_system.service.RoomService;
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
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Override
    public List<RoomVo> listRoomVo() {
        return baseMapper.selectRoomVoList();
    }

    @Override
    public List<RoomVo> listRoomVo(Wrapper wrapper) {
        return baseMapper.selectRoomVoListByWrapper(wrapper);
    }

    @Override
    public IPage<RoomVo> pageRoomVo(Page<RoomVo> page) {
        return baseMapper.selectRoomVoPage(page);
    }

    @Override
    public IPage<RoomVo> pageRoomVo(Page<RoomVo> page, Wrapper wrapper) {
        return baseMapper.selectRoomVoPageByWrapper(page, wrapper);
    }
}
