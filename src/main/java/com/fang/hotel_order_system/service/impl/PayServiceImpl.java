package com.fang.hotel_order_system.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fang.hotel_order_system.config.AlipayConfig;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.service.OrdersService;
import com.fang.hotel_order_system.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private OrdersService ordersService;

    @Override
    public String pay(Orders orders) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orders.getOrdersId().toString();
        //付款金额，必填
        String total_amount = String.valueOf(orders.getPrice());
        //订单名称，必填
        String subject = "支付宝沙箱测试";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        alipayRequest.setReturnUrl("http://localhost");
        String body = alipayClient.pageExecute(alipayRequest).getBody();
        return body;
    }

    @Override
    public String refund(Orders orders) throws AlipayApiException, IOException {
        return null;
    }
}
