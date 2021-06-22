package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.JwtUser;
import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.entity.User;
import com.fang.hotel_order_system.entity.vo.UserVo;
import com.fang.hotel_order_system.mapper.UserMapper;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        List<Permission> permissionList = permissionService.listByUserId(user.getUserId());
        System.out.println("loadUserByUsername: " + permissionList.toString());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissionList) {
            if (permission != null && permission.getValue() != null) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission.getValue());
                authorities.add(authority);
            }
        }
        return new JwtUser(user, authorities);
    }

    @Override
    public List<UserVo> listUserVo() {
        return baseMapper.selectUserVoList();
    }

    @Override
    public IPage<UserVo> pageUserVo(Page<UserVo> page) {
        return baseMapper.selectUserVoPage(page);
    }
}
