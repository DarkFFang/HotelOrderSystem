package com.fang.hotel_order_system.controller;

import com.alipay.api.AlipayApiException;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.service.PayService;
import com.fang.hotel_order_system.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/alipay")
public class PayController {
    @Autowired
    private PayService payService;

    @GetMapping("/pay")
    public JsonResponse pay(Orders orders) throws AlipayApiException, IOException {
        return JsonResponse.success(payService.pay(orders));
    }

    @PostMapping("/notify")
    public JsonResponse payNotify(HttpServletRequest request, HttpServletResponse response  ) {
        return payService.notifyInfo(request,response);
    }
}
