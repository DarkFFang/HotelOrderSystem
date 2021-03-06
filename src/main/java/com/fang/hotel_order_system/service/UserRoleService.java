package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface UserRoleService extends IService<UserRole> {
    boolean updateByUserId(Long userId, Long[] roleIdList);

}
