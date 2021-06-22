package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface RolePermissionService extends IService<RolePermission> {

    boolean updateByRoleId(Long roleId, Long[] permissionIdList);
}
