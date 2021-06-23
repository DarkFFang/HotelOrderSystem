package com.fang.hotel_order_system.mapper;

import com.fang.hotel_order_system.entity.Breakfast;
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
public interface BreakfastMapper extends BaseMapper<Breakfast> {

    Breakfast selectByPrimaryKey(Integer breakfastId);

    List<Breakfast> queryList(Breakfast record);

    int updateByPrimaryKey(Breakfast record);

    void deleteAllMenuOfBreakfast(Integer breakfastId);

    void saveBreakfastMenu(Integer breakfastId, Integer menuId);

    void getUserCountUseBreakfast(Integer breakfastId);

    void deleteUserBreakfast(Integer breakfastId);

    void deleteBreakfastMenu(Integer breakfastId);

    void deleteByPrimaryKey(Integer breakfastId);
}
