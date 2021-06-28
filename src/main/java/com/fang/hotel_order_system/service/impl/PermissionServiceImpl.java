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
 * 服务实现类
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
        menuVoList = findMenuVoChildren(menuVoList, menuVoList);
        Iterator<MenuVo> iterator = menuVoList.iterator();
        while (iterator.hasNext()) {
            MenuVo menuVo = iterator.next();
            if (menuVo.getPid() != 0) {
                iterator.remove();
            }
        }
        menuVoList = trimMenuVo(menuVoList);
        return menuVoList;
    }

    private List<MenuVo> findMenuVoChildren(List<MenuVo> menuVoList, List<MenuVo> menuVoListResource) {
        for (MenuVo menuVo : menuVoList) {
            List<MenuVo> children = new ArrayList<>();
            for (MenuVo menuVoResource : menuVoListResource) {
                if (menuVoResource.getPid().equals(menuVo.getPermissionId())) {
                    children.add(menuVoResource);
                }
            }
            findMenuVoChildren(children, menuVoListResource);
            menuVo.setChildren(children);
        }
        return menuVoList;
    }

    private List<MenuVo> trimMenuVo(List<MenuVo> menuVoList) {
        Iterator<MenuVo> iterator = menuVoList.iterator();
        while (iterator.hasNext()) {
            MenuVo menuVo = iterator.next();
            if (!menuVo.getChildren().isEmpty()) {
                trimMenuVo(menuVo.getChildren());
            } else {
                iterator.remove();
            }
        }
        return menuVoList;
    }
}