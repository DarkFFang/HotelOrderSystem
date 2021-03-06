package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.Country;
import com.fang.hotel_order_system.mapper.CountryMapper;
import com.fang.hotel_order_system.service.CountryService;
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
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {

}
