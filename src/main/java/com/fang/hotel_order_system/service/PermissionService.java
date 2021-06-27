package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> listByUserId(Long userId);
    List<Permission> listByRoleId(Long roleId);

    List<MenuVo> listMenuByUserId(Long userId);

}
