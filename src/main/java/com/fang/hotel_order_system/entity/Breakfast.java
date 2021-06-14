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
@ApiModel(value = "Breakfast对象", description = "")
public class Breakfast extends Model<Breakfast> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "早餐编号")
    @TableId
    private Long breakfastId;

    @ApiModelProperty(value = "早餐名称")
    private String breakfastType;


    @Override
    protected Serializable pkVal() {
        return this.breakfastId;
    }

}
