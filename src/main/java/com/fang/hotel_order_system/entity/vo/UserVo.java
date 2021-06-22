package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Role;
import com.fang.hotel_order_system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVo extends User {
    private List<Role> roleList;

}
