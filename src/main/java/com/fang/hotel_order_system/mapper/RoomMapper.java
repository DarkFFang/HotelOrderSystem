package com.fang.hotel_order_system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.hotel_order_system.entity.vo.HotelVo;
import com.fang.hotel_order_system.entity.vo.RoomVo;
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
public interface RoomMapper extends BaseMapper<Room> {
    List<RoomVo> selectRoomVoList();

    IPage<RoomVo> selectRoomVoPage(Page<RoomVo> page);

    List<RoomVo> selectRoomVoListByWrapper(Wrapper ew);

    IPage<RoomVo> selectRoomVoPageByWrapper(Page<RoomVo> page, Wrapper ew);

}
