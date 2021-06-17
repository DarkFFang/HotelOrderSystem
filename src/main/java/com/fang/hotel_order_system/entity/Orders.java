package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@ApiModel(value = "Orders对象", description = "")
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单编号")
    @TableId
    private Long ordersId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "酒店编号")
    private Long hotelId;

    @ApiModelProperty(value = "房间编号")
    private Long roomId;

    @ApiModelProperty(value = "状态编号")
    private Integer statusId;

    @ApiModelProperty(value = "房间数量")
    private Integer quantity;

    @ApiModelProperty(value = "入住时间")
    private LocalDateTime inTime;

    @ApiModelProperty(value = "退房时间")
    private LocalDateTime outTime;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "下单时间")
    private LocalDateTime orderTime;


    @Override
    protected Serializable pkVal() {
        return this.ordersId;
    }

}
