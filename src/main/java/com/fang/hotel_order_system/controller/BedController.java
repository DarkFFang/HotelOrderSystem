package com.fang.hotel_order_system.controller;

import com.fang.hotel_order_system.entity.Bed;
import com.fang.hotel_order_system.service.BedService;
import com.fang.hotel_order_system.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-14
 */
@RestController
@RequestMapping("/api/bed")
public class BedController {

    private final Logger logger = LoggerFactory.getLogger(BedController.class);

    @Autowired
    private BedService bedService;

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Bed bed = bedService.getById(id);
        return JsonResponse.success(bed);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        bedService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateBed(Bed bed) throws Exception {
        return JsonResponse.success(bedService.updateById(bed));
    }


    /**
     * 描述:创建Bed
     */
    @PostMapping("")
    public JsonResponse create(Bed bed) throws Exception {
        bedService.save(bed);
        return JsonResponse.success(null);
    }
}

