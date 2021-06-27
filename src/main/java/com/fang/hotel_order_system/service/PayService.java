package com.fang.hotel_order_system.service;

import com.alipay.api.AlipayApiException;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.util.JsonResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PayService {
    String pay(Orders orders) throws AlipayApiException, IOException;

    String refund(Orders orders) throws AlipayApiException, IOException;

    JsonResponse notifyInfo(HttpServletRequest request, HttpServletResponse response);
}
