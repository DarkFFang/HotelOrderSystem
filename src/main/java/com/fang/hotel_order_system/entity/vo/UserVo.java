package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Role;
import com.fang.hotel_order_system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVo extends User {
    private List<Role> roleList;

    public UserVo(User user,List<Role> roleList) {
        this.setUserId(user.getUserId());
        this.setUsername(user.getUsername());
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setNickname(user.getNickname());
        this.setCreateTime(user.getCreateTime());
        this.setIcon(user.getIcon());
        this.setRoleList(roleList);
    }
}
