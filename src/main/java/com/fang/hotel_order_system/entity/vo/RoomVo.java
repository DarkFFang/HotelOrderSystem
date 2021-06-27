package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Bed;
import com.fang.hotel_order_system.entity.Breakfast;
import com.fang.hotel_order_system.entity.Room;
import com.fang.hotel_order_system.entity.RoomType;
import lombok.Data;

@Data
public class RoomVo extends Room {
    private RoomType roomType;
    private Bed bed;
    private Breakfast breakfast;
}
