package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.mapper.PermissionMapper;
import com.fang.hotel_order_system.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Permission> listByUserId(Long userId) {
        List<Permission> permissionList = baseMapper.selectListByUserId(userId);
        Set<Permission> permissionSet = new LinkedHashSet<>(permissionList);
        permissionList.clear();
        permissionList.addAll(permissionSet);
        return permissionList;
    }

    @Override
    public List<Permission> listByRoleId(Long roleId) {
        return baseMapper.selectListByRoleId(roleId);
    }
}
