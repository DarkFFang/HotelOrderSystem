package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.JwtUser;
import com.fang.hotel_order_system.entity.Orders;
import com.fang.hotel_order_system.entity.vo.CommentVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.CommentService;
import com.fang.hotel_order_system.entity.Comment;

import java.util.List;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<Comment> commentList = commentService.list();
        return JsonResponse.success(commentList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Comment> page = new Page<>(current, size);
        commentService.page(page);
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询相关用户的整个列表
     */
    @GetMapping("/userId/{userId}")
    public JsonResponse getListByUserId(@PathVariable Long userId) throws Exception {
        List<Comment> ordersList = commentService.list(new QueryWrapper<Comment>().eq("user_id", userId));
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("/userId/{userId}/page/{current}/{size}")
    public JsonResponse getListPageByUserId(@PathVariable Long userId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Comment> page = new Page<>(current, size);
        commentService.page(page, new QueryWrapper<Comment>().eq("user_id", userId));
        return JsonResponse.success(page);
    }

    @GetMapping("/hotelId/{hotelId}")
    public JsonResponse getListByHotelId(@PathVariable Long hotelId) throws Exception {
        List<Comment> ordersList = commentService.list(new QueryWrapper<Comment>().eq("hotel_id", hotelId));
        return JsonResponse.success(ordersList);
    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("/hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getListPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Comment> page = new Page<>(current, size);
        commentService.page(page, new QueryWrapper<Comment>().eq("hotel_id", hotelId));
        return JsonResponse.success(page);
    }
    /**
     * 描述：查询整个列表
     */
    @GetMapping("commentVo/")
    public JsonResponse getCommentVoVoList() throws Exception {
        List<CommentVo> commentList = commentService.listCommentVo();
        return JsonResponse.success(commentList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("commentVo/page/{current}/{size}")
    public JsonResponse getCommentVoPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<CommentVo> page = new Page<>(current, size);
        commentService.pageCommentVo(page);
        return JsonResponse.success(page);
    }

//    /**
//     * 描述：查询相关用户的整个列表
//     */
//    @GetMapping("commentVo/userId/{userId}")
//    public JsonResponse getListByUserId(@PathVariable Long userId) throws Exception {
//        List<CommentVo> ordersList = commentService.list(new QueryWrapper<CommentVo>().eq("user_id", userId));
//        return JsonResponse.success(ordersList);
//    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("commentVo/userId/{userId}/page/{current}/{size}")
    public JsonResponse getCommentVoPageByUserId(@PathVariable Long userId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<CommentVo> page = new Page<>(current, size);
        commentService.pageCommentVo(page, new QueryWrapper<CommentVo>().eq("user_id", userId));
        return JsonResponse.success(page);
    }

//    @GetMapping("commentVo/hotelId/{hotelId}")
//    public JsonResponse getListByHotelId(@PathVariable Long hotelId) throws Exception {
//        List<CommentVo> ordersList = commentService.list(new QueryWrapper<CommentVo>().eq("hotel_id", hotelId));
//        return JsonResponse.success(ordersList);
//    }

    /**
     * 描述：查询相关用户的列表,并分页
     */
    @GetMapping("commentVo/hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getCommentVoPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<CommentVo> page = new Page<>(current, size);
        commentService.pageCommentVo(page, new QueryWrapper<CommentVo>().eq("hotel_id", hotelId));
        return JsonResponse.success(page);
    }
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
        if (commentService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByCommentId(Comment comment) throws Exception {
        if (commentService.updateById(comment)) {
            return JsonResponse.success(comment, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
     * 描述:创建Comment
     */
    @PostMapping("")
    public JsonResponse create(Comment comment) throws Exception {
        JwtUser jwtUser = (JwtUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        comment.setUserId(jwtUser.getUser().getUserId());
        if (commentService.save(comment)) {
            return JsonResponse.success(comment, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }


    }
}

