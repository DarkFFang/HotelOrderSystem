package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Permission;
import lombok.Data;

import java.util.List;

@Data
public class MenuVo extends Permission {
    List<MenuVo> children;
}

