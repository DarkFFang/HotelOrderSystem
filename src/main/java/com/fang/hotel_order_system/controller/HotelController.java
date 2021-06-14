package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.HotelService;
import com.fang.hotel_order_system.entity.Hotel;


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
@RequestMapping("/api/hotel")
public class HotelController {

    private final Logger logger = LoggerFactory.getLogger( HotelController.class );

    @Autowired
    private HotelService hotelService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Hotel  hotel =  hotelService.getById(id);
        return JsonResponse.success(hotel);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        hotelService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updateHotel(@PathVariable("id") Long  id,Hotel  hotel) throws Exception {
        hotel.setHotelId(id);
        hotelService.updateById(hotel);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Hotel
    *
    */
    @PostMapping("")
    public JsonResponse create(Hotel  hotel) throws Exception {
        hotelService.save(hotel);
        return JsonResponse.success(null);
    }
}

