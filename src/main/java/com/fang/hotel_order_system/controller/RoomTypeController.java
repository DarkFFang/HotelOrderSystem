package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.RoomTypeService;
import com.fang.hotel_order_system.entity.RoomType;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-17
 * @version v1.0
 */
@RestController
@RequestMapping("/api/roomType")
public class RoomTypeController {

    private final Logger logger = LoggerFactory.getLogger( RoomTypeController.class );

    @Autowired
    private RoomTypeService roomTypeService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<RoomType> roomTypeList =  roomTypeService.list();
        return JsonResponse.success(roomTypeList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        RoomType roomType =  roomTypeService.getById(id);
        return JsonResponse.success(roomType);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(roomTypeService.removeById(id)){
            return JsonResponse.successMessage("删除成功！");
        }else{
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("")
    public JsonResponse updateByIdRoomType(RoomType  roomType) throws Exception {
        if(roomTypeService.updateById(roomType)){
            return JsonResponse.success(roomType, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建RoomType
    *
    */
    @PostMapping("")
    public JsonResponse create(RoomType  roomType) throws Exception {
        if(roomTypeService.save(roomType)){
            return JsonResponse.success(roomType, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

