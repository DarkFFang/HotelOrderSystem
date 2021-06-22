package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface CommentService extends IService<Comment> {
    List<Comment> listByUserId(Long userId);

    IPage<Comment> pageByUserId(Page<Comment> page, Long userId);

}
