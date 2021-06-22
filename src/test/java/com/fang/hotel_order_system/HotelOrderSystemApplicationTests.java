package com.fang.hotel_order_system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Bed;
import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.entity.Status;
import com.fang.hotel_order_system.entity.User;
import com.fang.hotel_order_system.mapper.BedMapper;
import com.fang.hotel_order_system.mapper.UserMapper;
import com.fang.hotel_order_system.service.MailService;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.service.StatusService;
import com.fang.hotel_order_system.service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private MailService mailService;

    @Autowired
    private BedMapper bedMapper;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("123456"));
        Bed bed = new Bed();
        bed.setBedType("测试床");
        System.out.println(bedMapper.insert(bed));
    }

    @Test
    void pageTest() {
        Page<Status> page = new Page<>(2, 5);
        statusService.page(page);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void verifyCodeTest() {
        mailService.sendVerifyCode("a123123sd@qq.com","123456");
    }

}
