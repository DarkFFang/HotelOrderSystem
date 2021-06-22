package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fang.hotel_order_system.entity.RolePermission;
import com.fang.hotel_order_system.mapper.RolePermissionMapper;
import com.fang.hotel_order_system.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Override
    @Transactional
    public boolean updateByRoleId(Long roleId, Long[] permissionIdList) {
        int count = baseMapper.selectCount(new QueryWrapper<RolePermission>().eq("role_id", roleId));
        if (count != baseMapper.delete(new QueryWrapper<RolePermission>().eq("role_id", roleId))) {
            throw new RuntimeException("删除记录失败！");
        }
        if (permissionIdList == null) {
            return true;
        }
        for (Long permissionId : permissionIdList) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            if (0 == baseMapper.insert(rolePermission)) {
                throw new RuntimeException("插入记录失败！");
            }
        }
        return true;
    }
}
