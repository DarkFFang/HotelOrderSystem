package com.fang.hotel_order_system.entity.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String verifyCode;
}
