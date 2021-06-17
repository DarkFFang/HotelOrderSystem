package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.RoomService;
import com.fang.hotel_order_system.entity.Room;

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
@RequestMapping("/api/room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger( RoomController.class );

    @Autowired
    private RoomService roomService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Room> roomList =  roomService.list();
        return JsonResponse.success(roomList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Room room =  roomService.getById(id);
        return JsonResponse.success(room);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(roomService.removeById(id)){
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
    public JsonResponse updateByIdRoom(Room  room) throws Exception {
        if(roomService.updateById(room)){
            return JsonResponse.success(room, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Room
    *
    */
    @PostMapping("")
    public JsonResponse create(Room  room) throws Exception {
        if(roomService.save(room)){
            return JsonResponse.success(room, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

