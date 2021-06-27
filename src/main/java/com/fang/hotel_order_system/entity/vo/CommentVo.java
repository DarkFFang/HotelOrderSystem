package com.fang.hotel_order_system.entity.vo;

import com.fang.hotel_order_system.entity.Comment;
import lombok.Data;

@Data
public class CommentVo extends Comment {
    private String icon;
    private String nickname;
    private String hotelName;
}
