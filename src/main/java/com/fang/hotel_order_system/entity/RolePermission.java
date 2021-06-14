package com.fang.hotel_order_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

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
@ApiModel(value = "RolePermission对象", description = "")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色权限关系的编号")
    @TableId(value = "role_permission_id", type = IdType.AUTO)
    private Long rolePermissionId;

    @ApiModelProperty(value = "角色编号")
    private Long roleId;

    @ApiModelProperty(value = "权限编号")
    private Long permissionId;


    @Override
    protected Serializable pkVal() {
        return this.rolePermissionId;
    }

}
