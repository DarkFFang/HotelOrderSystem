package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface RoleService extends IService<Role> {
    List<Role> ListByUserId(Long userId);


}
