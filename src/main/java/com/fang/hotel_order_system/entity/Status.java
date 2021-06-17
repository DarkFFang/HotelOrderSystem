package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value = "Status对象", description = "")
public class Status extends Model<Status> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态编号")
    @TableId(type = IdType.AUTO)
    private Integer statusId;

    @ApiModelProperty(value = "状态值")
    private String value;

    @Override
    protected Serializable pkVal() {
        return this.statusId;
    }
}
