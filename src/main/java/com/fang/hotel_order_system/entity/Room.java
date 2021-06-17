package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

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
@ApiModel(value = "Room对象", description = "")
public class Room extends Model<Room> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房间编号")
    @TableId
    private Long roomId;

    @ApiModelProperty(value = "酒店编号")
    private Long hotelId;

    @ApiModelProperty(value = "早餐编号")
    private Long breakfastId;

    @ApiModelProperty(value = "房型编号")
    private Long roomTypeId;

    @ApiModelProperty(value = "床型编号")
    private Long bedId;

    @ApiModelProperty(value = "房间价格")
    private Integer price;

    @ApiModelProperty(value = "房间剩余数量")
    private Integer remainQuantity;


    @Override
    protected Serializable pkVal() {
        return this.roomId;
    }

}
