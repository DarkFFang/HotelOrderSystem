package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Comment对象", description = "")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论编号")
    @TableId
    private Long commentId;

    @ApiModelProperty(value = "酒店编号")
    private Long hotelId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "订单编号")
    private Long ordersId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "用户评分")
    private Integer score;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

}
