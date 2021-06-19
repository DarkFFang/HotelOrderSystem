package com.fang.hotel_order_system.entity.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;

    private String phone;

    private String email;

    private String password;

    private String verifyCode;
}
