package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.HotelService;
import com.fang.hotel_order_system.entity.Hotel;

import java.util.List;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HotelService hotelService;

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<Hotel> hotelList = hotelService.list();
        return JsonResponse.success(hotelList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Hotel> page = new Page<>(current, size);
        hotelService.page(page);
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/keyword/{keyword}/page/{current}/{size}")
    public JsonResponse getListPageByKeyword(@PathVariable String keyword, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Hotel> page = new Page<>(current, size);
        hotelService.page(page, new QueryWrapper<Hotel>().like("hotel_name", keyword)
                .or().like("address", keyword)
                .or().like("brand", keyword)
                .or().like("description", keyword));
        return JsonResponse.success(page);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/starRank/{starRank}/page/{current}/{size}")
    public JsonResponse getListPageByStatRank(@PathVariable Integer starRank, @PathVariable long current, @PathVariable long size) throws Exception {
        Page<Hotel> page = new Page<>(current, size);
        hotelService.page(page, new QueryWrapper<Hotel>().eq("star_rank", starRank));
        return JsonResponse.success(page);
    }

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Hotel hotel = hotelService.getById(id);
        return JsonResponse.success(hotel);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if (hotelService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByHotelId(Hotel hotel) throws Exception {
        if (hotelService.updateById(hotel)) {
            return JsonResponse.success(hotel, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
     * 描述:创建Hotel
     */
    @PostMapping("")
    public JsonResponse create(Hotel hotel) throws Exception {
        if (hotelService.save(hotel)) {
            return JsonResponse.success(hotel, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }


    }
}

