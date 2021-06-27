package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Comment;
import com.fang.hotel_order_system.entity.vo.CommentVo;
import com.fang.hotel_order_system.mapper.CommentMapper;
import com.fang.hotel_order_system.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public List<CommentVo> listCommentVo() {
        return baseMapper.selectCommentVoList();
    }

    @Override
    public IPage<CommentVo> pageCommentVo(Page<CommentVo> page) {
        return baseMapper.selectCommentVoPage(page);
    }

    @Override
    public IPage<CommentVo> pageCommentVo(Page<CommentVo> page, Wrapper ew) {
        return baseMapper.selectCommentVoPageByWrapper(page, ew);
    }
}
