package com.fang.hotel_order_system.service;

public interface MailService {

    void sendVerifyCode(String to, String keyMessage, String verifyCode);
}
