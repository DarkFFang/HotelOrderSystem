package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.CommentVo;

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
    List<CommentVo> listCommentVo();

    IPage<CommentVo> pageCommentVo(Page<CommentVo> page);

    IPage<CommentVo> pageCommentVo(Page<CommentVo> page, Wrapper ew);
}
