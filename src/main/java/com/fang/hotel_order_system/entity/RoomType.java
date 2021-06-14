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
@ApiModel(value = "RoomType对象", description = "")
public class RoomType extends Model<RoomType> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房型编号")
    @TableId
    private Long roomTypeId;

    @ApiModelProperty(value = "房型名称")
    private String roomTypeName;

    @ApiModelProperty(value = "最大入住数量")
    private Integer maxPeopleNumber;


    @Override
    protected Serializable pkVal() {
        return this.roomTypeId;
    }

}
