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
@ApiModel(value = "City对象", description = "")
public class City extends Model<City> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "城市编号")
    @TableId
    private Long cityId;

    @ApiModelProperty(value = "国家编号")
    private Integer countryId;

    @ApiModelProperty(value = "城市名字")
    private String cityName;

    @ApiModelProperty(value = "城市代码")
    private String cityCode;


    @Override
    protected Serializable pkVal() {
        return this.cityId;
    }

}
