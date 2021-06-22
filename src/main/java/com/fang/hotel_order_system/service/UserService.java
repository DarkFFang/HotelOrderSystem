package com.fang.hotel_order_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface UserService extends IService<User>, UserDetailsService {
    List<UserVo> listUserVo();

    IPage<UserVo> pageUserVo(Page<UserVo> page);

}
