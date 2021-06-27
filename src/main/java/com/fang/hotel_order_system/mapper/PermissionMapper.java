package com.fang.hotel_order_system.mapper;

import com.fang.hotel_order_system.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.hotel_order_system.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectListByUserId(Long userId);

    List<Permission> selectListByRoleId(Long roleId);

    List<MenuVo> selectMenuVoListByUserId(Long userId);

    List<MenuVo> selectChildrenListByPermissionId(Long permissionId);
}
