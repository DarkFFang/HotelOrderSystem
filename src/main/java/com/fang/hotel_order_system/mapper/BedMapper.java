package com.fang.hotel_order_system.mapper;

import com.fang.hotel_order_system.entity.Bed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.hotel_order_system.entity.Breakfast;
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
public interface BedMapper extends BaseMapper<Bed> {

    Breakfast selectByPrimaryKey(Integer bedId);

    List<Breakfast> queryList(Bed record);

    int updateByPrimaryKey(Bed record);

    void deleteAllMenuOfBed(Integer bedId);

    void saveBedMenu(Integer bedId, Integer menuId);

    void getUserCountUseBed(Integer bedId);

    void deleteUserBed(Integer bedId);

    void deleteBedMenu(Integer bedId);

    void deleteByPrimaryKey(Integer bedId);
}
