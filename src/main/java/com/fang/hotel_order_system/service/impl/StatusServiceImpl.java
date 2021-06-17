package com.fang.hotel_order_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.hotel_order_system.entity.Status;
import com.fang.hotel_order_system.mapper.StatusMapper;
import com.fang.hotel_order_system.service.StatusService;
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
public class StatusServiceImpl extends ServiceImpl<StatusMapper, Status> implements StatusService {

}
