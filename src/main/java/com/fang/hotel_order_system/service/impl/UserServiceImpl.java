package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.User;
import com.fang.hotel_order_system.mapper.UserMapper;
import com.fang.hotel_order_system.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
