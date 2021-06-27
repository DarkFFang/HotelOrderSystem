package com.fang.hotel_order_system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.entity.vo.CommentVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Component
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentVo> selectCommentVoList();

    IPage<CommentVo> selectCommentVoPage(Page<CommentVo> page);

    IPage<CommentVo> selectCommentVoPageByWrapper(Page<CommentVo> page, Wrapper ew);
}
