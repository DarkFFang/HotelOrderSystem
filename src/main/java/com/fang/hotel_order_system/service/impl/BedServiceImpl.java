package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.Bed;
import com.fang.hotel_order_system.entity.Breakfast;
import com.fang.hotel_order_system.mapper.BedMapper;
import com.fang.hotel_order_system.mapper.BreakfastMapper;
import com.fang.hotel_order_system.service.BedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2021-06-14
 */
@Service
public abstract class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {
    @Resource
    private BedMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer bedId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(Bed record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Bed record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Breakfast selectByPrimaryKey(Integer bedId) {
        return mapper.selectByPrimaryKey(bedId);
    }

    @Override
    public List<Breakfast> selectRoles(Bed record) {
        return mapper.queryList(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Bed record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Bed record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public void assign(Integer bedId, Integer[] checkMenuIds) {
        // 先删除原来已经分配的角色和菜单的数据
        mapper.deleteAllMenuOfBed(bedId);
        // 在重新插入新选择的菜单项
        if (checkMenuIds != null && checkMenuIds.length >= 1) {
            for (Integer menuId : checkMenuIds) {
                // 插入到角色和菜单中间表
                mapper.saveBedMenu(bedId, menuId);
            }
        }
    }
    public Integer getUserCountUseBreakfast(Integer bedId){
        mapper.getUserCountUseBed(bedId);
        return bedId;
    }

    /**
     * 删除床型相关信息
     */
    public void deleteBedInfo (Integer bedId){

        mapper.deleteUserBed(bedId);

        mapper.deleteBedMenu(bedId);


        mapper.deleteByPrimaryKey(bedId);
    }
}
