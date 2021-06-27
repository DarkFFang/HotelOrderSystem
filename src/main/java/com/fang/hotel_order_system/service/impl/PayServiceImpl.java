package com.fang.hotel_order_system.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fang.hotel_order_system.config.AlipayConfig;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.service.OrdersService;
import com.fang.hotel_order_system.service.PayService;
import com.fang.hotel_order_system.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PayServiceImpl implements PayService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private OrdersService ordersService;

    @Override
    public String pay(Orders orders) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                AlipayConfig.format,
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orders.getOrdersId().toString();
        //付款金额，必填
        String total_amount = String.valueOf(orders.getPrice());
        //订单名称，必填
        String subject = "支付宝沙箱测试";
        alipayRequest.setBizContent(
                "{\"out_trade_no\":\"" + out_trade_no + "\","
                        + "\"total_amount\":\"" + total_amount + "\","
                        + "\"subject\":\"" + subject + "\","
                        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String body = alipayClient.pageExecute(alipayRequest).getBody();
        return body;
    }

    @Override
    public String refund(Orders orders) throws AlipayApiException, IOException {
        return null;
    }

    @Override
    public JsonResponse notifyInfo(HttpServletRequest request, HttpServletResponse response) {
        logger.info("收到支付宝异步回调 start...");
        //接收参数进行校验
        Map<String, String> parameters = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        System.out.println(requestParams.toString());
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            parameters.put(key, valueStr);
        }

        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(
                    parameters,
                    AlipayConfig.alipay_public_key,
                    AlipayConfig.charset,
                    AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            logger.error(e.getErrMsg());
            throw new RuntimeException("调用支付宝接口发生异常");
        }
        if (!signVerified) {
            return JsonResponse.failure("【支付宝异步通知】验证签名错误!");
        }
        String appId = request.getParameter("app_id");
        Long ordersId = Long.parseLong(request.getParameter("out_trade_no"));
        String tradeStatus = request.getParameter("trade_status");
        BigDecimal totalAmount = new BigDecimal(request.getParameter("total_amount"));
        BigDecimal receiptAmount = new BigDecimal(request.getParameter("receipt_amount"));
        logger.info("交易状态:{},支付金额为：{},实付金额为：{}", tradeStatus, totalAmount, receiptAmount);


        System.out.println(appId);

        System.out.println(ordersId);

        if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)) {
            Orders orders = new Orders();
            orders.setStatusId(2);
            orders.setOrdersId(ordersId);
            ordersService.updateById(orders);
            return JsonResponse.successMessage("支付成功！");
        }
        return JsonResponse.failure("【支付宝异步通知】状态错误");

    }
}
