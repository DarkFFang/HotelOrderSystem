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
@ApiModel(value = "Bed对象", description = "")
public class Bed extends Model<Bed> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "床型编号")
    @TableId
    private Long bedId;

    @ApiModelProperty(value = "床型名称")
    private String bedType;

    @ApiModelProperty(value = "床型图片")
    private String pic;


    @Override
    protected Serializable pkVal() {
        return this.bedId;
    }

}
