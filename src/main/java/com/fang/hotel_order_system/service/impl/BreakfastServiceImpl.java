package com.fang.hotel_order_system.service.impl;

import com.fang.hotel_order_system.entity.Breakfast;
import com.fang.hotel_order_system.mapper.BreakfastMapper;
import com.fang.hotel_order_system.service.BreakfastService;
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
public class BreakfastServiceImpl extends ServiceImpl<BreakfastMapper, Breakfast> implements BreakfastService {
    @Resource
    private BreakfastMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer breakfastId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(Breakfast record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Breakfast record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Breakfast selectByPrimaryKey(Integer breakfastId) {
        return mapper.selectByPrimaryKey(breakfastId);
    }

    @Override
    public List<Breakfast> selectRoles(Breakfast record) {
        return mapper.queryList(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Breakfast record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Breakfast record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public void assign(Integer breakfastId, Integer[] checkMenuIds) {
        // 先删除原来已经分配的角色和菜单的数据
        mapper.deleteAllMenuOfBreakfast(breakfastId);
        // 在重新插入新选择的菜单项
        if (checkMenuIds != null && checkMenuIds.length >= 1) {
            for (Integer menuId : checkMenuIds) {
                // 插入到角色和菜单中间表
                mapper.saveBreakfastMenu(breakfastId, menuId);
            }
        }
    }
    public Integer getUserCountUseBreakfast(Integer breakfastId){
        mapper.getUserCountUseBreakfast(breakfastId);
        return breakfastId;
    }

    /**
     * 删除角色和角色相关信息
     */
    public void deleteBreakfastInfo (Integer breakfastId){
// 删除用户和角色中间表信息
        mapper.deleteUserBreakfast(breakfastId);
// 删除角色和菜单中间表信息
        mapper.deleteBreakfastMenu(breakfastId);

// 删除角色信息
        mapper.deleteByPrimaryKey(breakfastId);
    }
}
