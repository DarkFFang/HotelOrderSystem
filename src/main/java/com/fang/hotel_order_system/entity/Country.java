package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value = "Country对象", description = "")
public class Country extends Model<Country> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "国家编号")
    @TableId(type = IdType.AUTO)
    private Integer countryId;

    @ApiModelProperty(value = "国家代码")
    private String countryCode;

    @ApiModelProperty(value = "国家中文名")
    private String countryNameZh;

    @ApiModelProperty(value = "国家英文名")
    private String countryNameEn;


    @Override
    protected Serializable pkVal() {
        return this.countryId;
    }

}
