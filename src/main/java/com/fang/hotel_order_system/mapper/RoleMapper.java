package com.fang.hotel_order_system.mapper;

import com.fang.hotel_order_system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectListByUserId(Long userId);
}
