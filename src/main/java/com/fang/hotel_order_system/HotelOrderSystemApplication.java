package com.fang.hotel_order_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.fang.hotel_order_system.mapper"})

public class HotelOrderSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelOrderSystemApplication.class, args);
    }

}
