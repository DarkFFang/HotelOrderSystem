package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value = "Hotel对象", description = "")
public class Hotel extends Model<Hotel> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "酒店编号")
    @TableId
    private Long hotelId;

    @ApiModelProperty(value = "城市编号")
    private Long cityId;

    @ApiModelProperty(value = "酒店名称")
    private String hotelName;

    @ApiModelProperty(value = "酒店地址")
    private String address;

    @ApiModelProperty(value = "星级")
    private Integer starRank;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "酒店描述")
    private String description;

    @ApiModelProperty(value = "酒店品牌")
    private String brand;

    @ApiModelProperty(value = "酒店图片1")
    private String pic1;

    @ApiModelProperty(value = "酒店图片2")
    private String pic2;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.hotelId;
    }

}
