package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.entity.vo.MenuVo;
import com.fang.hotel_order_system.mapper.PermissionMapper;
import com.fang.hotel_order_system.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<MenuVo> listMenuByUserId(Long userId) {
        List<MenuVo> menuVoList = baseMapper.selectMenuVoListByUserId(userId);
        for (MenuVo menuVo : menuVoList) {
            List<MenuVo> children = baseMapper.selectChildrenListByPermissionId(menuVo.getPermissionId());
            menuVo.setChildren(children);
        }
        Iterator<MenuVo> iterator = menuVoList.iterator();
        while (iterator.hasNext()) {
            MenuVo menuVo = iterator.next();
            if (menuVo.getPid() != 0) {
                iterator.remove();
            }
        }
        return menuVoList;
    }
}
