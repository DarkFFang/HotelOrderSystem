package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Room;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.RoomVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface RoomService extends IService<Room> {
    List<RoomVo> listRoomVo();

    List<RoomVo> listRoomVo(Wrapper wrapper);

    IPage<RoomVo> pageRoomVo(Page<RoomVo> page);

    IPage<RoomVo> pageRoomVo(Page<RoomVo> page, Wrapper wrapper);

}
