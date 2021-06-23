package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.Breakfast;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface BreakfastService extends IService<Breakfast> {

    int deleteByPrimaryKey(Integer breakfastId);

    int insert(Breakfast record);

    int insertSelective(Breakfast record);

    Breakfast selectByPrimaryKey(Integer breakfastId);

    List<Breakfast> selectRoles(Breakfast record);

    int updateByPrimaryKeySelective(Breakfast record);

    int updateByPrimaryKey(Breakfast record);

    void assign(Integer breakfastId, Integer[] checkMenuIds);
}
