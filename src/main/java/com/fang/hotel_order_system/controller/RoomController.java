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


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-14
 * @version v1.0
 */
@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger( RoomController.class );

    @Autowired
    private RoomService roomService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Room  room =  roomService.getById(id);
        return JsonResponse.success(room);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        roomService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updateRoom(@PathVariable("id") Long  id,Room  room) throws Exception {
        room.setRoomId(id);
        roomService.updateById(room);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Room
    *
    */
    @PostMapping("")
    public JsonResponse create(Room  room) throws Exception {
        roomService.save(room);
        return JsonResponse.success(null);
    }
}

