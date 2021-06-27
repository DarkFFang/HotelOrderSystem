package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.Room;
import com.fang.hotel_order_system.entity.vo.RoomVo;
import com.fang.hotel_order_system.service.RoomService;
import com.fang.hotel_order_system.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomService roomService;

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<Room> roomList = roomService.list();
        return JsonResponse.success(roomList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Room> page = new Page<>(current, size);
        roomService.page(page);
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询整个列表
     */
    @GetMapping("hotelId/{hotelId}")
    public JsonResponse getListByHotelId(@PathVariable Long hotelId) throws Exception {
        List<Room> roomList = roomService.list(new QueryWrapper<Room>().eq("hotel_id", hotelId));
        return JsonResponse.success(roomList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getListPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Room> page = new Page<>(current, size);
        roomService.page(page, new QueryWrapper<Room>().eq("hotel_id", hotelId));
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询整个列表
     */
    @GetMapping("/roomVo")
    public JsonResponse getRoomVoList() throws Exception {
        List<RoomVo> roomList = roomService.listRoomVo();
        return JsonResponse.success(roomList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("roomVo/page/{current}/{size}")
    public JsonResponse getRoomVoListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<RoomVo> page = new Page<>(current, size);
        roomService.pageRoomVo(page);
        return JsonResponse.success(page);
    }

//    /**
//     * 描述：查询整个列表
//     */
//    @GetMapping("roomVo/hotelId/{hotelId}")
//    public JsonResponse getRoomVoListByHotelId(@PathVariable Long hotelId) throws Exception {
//        List<RoomVo> roomList = roomService.listRoomVo(new QueryWrapper<RoomVo>().eq("hotel_id", hotelId));
//        return JsonResponse.success(roomList);
//    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("roomVo/hotelId/{hotelId}/page/{current}/{size}")
    public JsonResponse getRoomVoListPageByHotelId(@PathVariable Long hotelId, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<RoomVo> page = new Page<>(current, size);
        roomService.pageRoomVo(page, new QueryWrapper<RoomVo>().eq("hotel_id", hotelId));
        return JsonResponse.success(page);
    }

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Room room = roomService.getById(id);
        return JsonResponse.success(room);
    }


    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if (roomService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByRoomId(Room room) throws Exception {
        if (roomService.updateById(room)) {
            return JsonResponse.success(room, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
     * 描述:创建Room
     */
    @PostMapping("")
    public JsonResponse create(Room room) throws Exception {
        if (roomService.save(room)) {
            return JsonResponse.success(room, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }


    }
}

