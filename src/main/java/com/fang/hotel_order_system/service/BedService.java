package com.fang.hotel_order_system.service;

import com.fang.hotel_order_system.entity.Bed;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.hotel_order_system.entity.Breakfast;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
public interface BedService extends IService<Bed> {

    int deleteByPrimaryKey(Integer bedId);

    int insert(Bed record);

    int insertSelective(Bed record);

    Breakfast selectByPrimaryKey(Integer bedId);

    List<Breakfast> selectRoles(Breakfast record);

    List<Breakfast> selectRoles(Bed record);

    int updateByPrimaryKeySelective(Breakfast record);

    int updateByPrimaryKey(Breakfast record);

    int updateByPrimaryKeySelective(Bed record);

    int updateByPrimaryKey(Bed record);

    void assign(Integer breakfastId, Integer[] checkMenuIds);
}
