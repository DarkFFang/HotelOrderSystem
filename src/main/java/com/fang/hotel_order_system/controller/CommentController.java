package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.CommentService;
import com.fang.hotel_order_system.entity.Comment;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-14
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Comment comment = commentService.getById(id);
        return JsonResponse.success(comment);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        commentService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("/{id}")
    public JsonResponse updateComment(@PathVariable("id") Long id, Comment comment) throws Exception {
        comment.setCommentId(id);
        commentService.updateById(comment);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Comment
     */
    @PostMapping("")
    public JsonResponse create(Comment comment) throws Exception {
        commentService.save(comment);
        return JsonResponse.success(null);
    }
}

