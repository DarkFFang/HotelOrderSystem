package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.BedService;
import com.fang.hotel_order_system.entity.Bed;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-18
 * @version v1.0
 */
@RestController
@RequestMapping("/api/bed")
public class BedController {

    private final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private BedService bedService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Bed> bedList =  bedService.list();
        return JsonResponse.success(bedList);
    }

    /**
    * 描述：查询整个列表,并分页
    *
    */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current,@PathVariable long size)throws Exception {
        Page<Bed> page=new Page<>(current,size);
        bedService.page(page);
        return JsonResponse.success(page);
    }

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Bed bed =  bedService.getById(id);
        return JsonResponse.success(bed);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(bedService.removeById(id)){
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
    public JsonResponse updateByBedId(Bed  bed) throws Exception {
        if(bedService.updateById(bed)){
            return JsonResponse.success(bed, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Bed
    *
    */
    @PostMapping("")
    public JsonResponse create(Bed  bed) throws Exception {
        if(bedService.save(bed)){
            return JsonResponse.success(bed, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

