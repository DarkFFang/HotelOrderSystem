package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fang.hotel_order_system.entity.UserRole;
import com.fang.hotel_order_system.mapper.UserRoleMapper;
import com.fang.hotel_order_system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
    @Override
    public boolean updateByUserId(Long userId, Long[] roleIdList) {
        int count = baseMapper.selectCount(new QueryWrapper<UserRole>().eq("user_id", userId));
        if (count != baseMapper.delete(new QueryWrapper<UserRole>().eq("user_id", userId))) {
            throw new RuntimeException("删除记录失败！");
        }
        if (roleIdList == null) {
            return true;
        }
        for (Long roleId : roleIdList) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            if (0 == baseMapper.insert(userRole)) {
                throw new RuntimeException("插入记录失败！");
            }
        }
        return true;
    }
}
