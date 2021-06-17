package com.fang.hotel_order_system;

import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.mapper.UserMapper;
import com.fang.hotel_order_system.service.PermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class HotelOrderSystemApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    void contextLoads() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
        System.out.println(permissionService.toString());
        List<Permission> permissionList = permissionService.listByUserId(1L);
        System.out.println(permissionList.toString());
    }

}
