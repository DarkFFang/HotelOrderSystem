package com.fang.hotel_order_system.entity.vo;


import com.fang.hotel_order_system.entity.Hotel;
import lombok.Data;

@Data
public class HotelVo extends Hotel {
    private Integer lowestPrice;
}
