package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Orders;
import lombok.Data;

@Data
public class OrdersVo extends Orders {
    private String hotelName;
    private String username;
}
