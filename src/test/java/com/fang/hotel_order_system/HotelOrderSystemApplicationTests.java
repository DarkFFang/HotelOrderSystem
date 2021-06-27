package com.fang.hotel_order_system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.*;
import com.fang.hotel_order_system.mapper.BedMapper;
import com.fang.hotel_order_system.mapper.UserMapper;
import com.fang.hotel_order_system.service.*;
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
    private HotelService hotelService;

    @Autowired
    private BedMapper bedMapper;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("123456"));
        Bed bed = new Bed();
        bed.setBedType("测试床");
        System.out.println(bedMapper.insert(bed));

        permissionService.listByUserId(1L).forEach(System.out::println);
    }

    @Test
    void pageTest() {
        Page<Status> page = new Page<>(2, 5);
        statusService.page(page);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void keywordList() {
        Page<Hotel> page = new Page<>(1, 5);
        String keyword = "成都";
        hotelService.page(page, new QueryWrapper<Hotel>().like("hotel_name", keyword)
                .or().like("address", keyword)
                .or().like("brand", keyword));
        System.out.println(page.getRecords());

        System.out.println(hotelService.list(new QueryWrapper<Hotel>().like("hotel_name", keyword)
                .or().like("address", keyword)
                .or().like("brand", keyword)));
    }

    @Test
    void menuTest() {
        System.out.println(permissionService.listMenuByUserId(1L).toString());
    }
}
