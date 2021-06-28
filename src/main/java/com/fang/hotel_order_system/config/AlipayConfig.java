package com.fang.hotel_order_system.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {


    // 作为身份标识的应用ID
    public static String app_id = "2021000117676217";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCORNvYWj4hBITXozPTMGqlOANexFmY+zFL07Lk1TSi0AuKvcBItEq1j03JF2uHM5fdy8cIQa6ciPaWSmXKPMBM+Rhgojz37in3YTmdQixTO10Lma+ZBssELda6Mv/c6bR7mvVIIvK6ylPgwX+q7pPUpWEp3DfjShJ8vSbWNWiXf29EVz+/SRGToJQcxEFOIjmt0K7HCl6V5btL6v6QuraWTiyVa579qh0WMyGGG4+lSmUQ7VEM92H4SPCGz5e2axIGRLz1aGiWPfWAgPiyKMdMknueq6SwWC2pgzlCtfE4gF+UskOZOQBvqNhGMbopX+oFLFoQrE38O23AKakyp4YFAgMBAAECggEAaKnz6skJKBVA/btNJzNZYc9Be3iMSeWSsKw/0eWgYZ8Yvqs2SMaKp+OTYDtgmgi00zFVbZeUtAh3EL4PAKeM+ZPQAVeZ7vRB34KhdjX2kgz8OMqJytSaiqqGbFmUrpsocj7f8H/1fsHWz2TLXZ9DFo/MWZVvcEFQNICbj7+fAMRZGajvDpibeKmLn5lErHjxOqho/CUJc5iqhOTl9eb9ZAzg5ERjR1X3IV6vGo0YkG/TBWESMRvty3f+ajp3NhIHMsXXUMKn7Ky/E0avD7KoJUT9j6q/N/zbk6cxNoRdPg0qOFUnNYjxywjhyaZbg3gHBi3dT0yHVTH2Y9nbFQ1LgQKBgQDxoZ8B/PGM9EQl2BDHYT8ID2MIKS1e9vCa54GVL9cXSyeys27DYY3ioNwNAlAbL8Us3Y20d1tMc8erVpaLviatfqyPg5/HxdehCp8TJkNILI9TylM09yAYpTk0a5mZjNZ0VnC8+yYpXbekvdJqctWtECONnGvJcvcg4BeKhEP1kQKBgQCWuqJclDPjzq+cQSu08DPm+k8BYIak8yWaZmPaarpsS0a7i+wEnMs+MHQfGIG1WzFqKzekjv5D+D7+5dyWWOrrDQ1086h9j7wwP5u7prY1pn1ItBJa1Nbq6I7ZSAc4zwCwHhJ2pHHCWhYWpTP3vlZGcGph31aPYUc2UiGxhTc/NQKBgFY/q4NJJ2t50U1012BjvN0CqQXDtPc9y9pvIlj/L5aX8/6cf7/r9Xpcks9t8OwTXB1MpAUzyXn7pdzp1mjhIesx2SSNBh6H5xULtoZeVQvRJAPzp0mzoFhLuaSVd8lQdUgnhqxeNVv0oNWEEDSA8vaIWTh2Ch9pEv9AHgcKeTuRAoGABTBHhohTgPQMd4SGzKO4JatYLOP1vpfgI4CCz3H9GN0+ghY++amsFWf1l1xwmp2ZBd6W+8MwXYaeJIglH8fPzmeUnwIEOs5H3CFUaxFCFHa2uVn5h8br3wpCYJhqJzp4+5cNa6gdgmM3f3AQaebTcXlNMDFP+X+Pw/7vyfyb+kECgYByq6Am/gdKR7QkUC8nevT10O1cXpZnwmsNKIsw25cx63tXF2fb9Mmx62lWGJ8cxKbLNPj2Vj/jnzi/9RW7JOFDke3dryHCPrH+Dr5yJilY6qQF+WBu6NyGormIUH074TW2rATiUXzlHJfBMCY2zxz6MzTASxi0dh7oyfihJYOVdw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmErkqO5WhoikVQQRM3IwQpV0z+6Q2tkcU/UVxj0ZGiWaD08+xp7E+Ob4oI8/5LHCUoh30B7JzOgT6ERS9Gj+NzR4Hod8vHjmFETxdGBZSfWXcYhSRpXuAG1GYNoTqtRPmOvDRbt6YSeNzaKKsz3EwcVvRMlHQxYfWHCWMrUK2uckRwXOKN/zyauUkpbHRY60dtDgSZ6cJaKLzqmZU6LRgFUzi9F7K6m8zMOnLvJYGVHYFPNJkRKPDwEPXHkMW8FFj8bTosbf4zPcMGW4P2BdwZmAys7NkqXsl0Hdg/TCkmS8grM1tT3IaWDnWFmnNfmnftujAFo/2mGNJHfQHEflwQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://119.29.40.206:8000/api/alipay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://119.29.40.206:8000/api/alipay/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    public static String format = "json";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
