package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.StatusService;
import com.fang.hotel_order_system.entity.Status;

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
@RequestMapping("/api/status")
public class StatusController {

    private final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private StatusService statusService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<Status> statusList =  statusService.list();
        return JsonResponse.success(statusList);
    }

    /**
    * 描述：查询整个列表,并分页
    *
    */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current,@PathVariable long size)throws Exception {
        Page<Status> page=new Page<>(current,size);
        statusService.page(page);
        return JsonResponse.success(page);
    }

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Status status =  statusService.getById(id);
        return JsonResponse.success(status);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(statusService.removeById(id)){
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
    public JsonResponse updateByStatusId(Status  status) throws Exception {
        if(statusService.updateById(status)){
            return JsonResponse.success(status, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建Status
    *
    */
    @PostMapping("")
    public JsonResponse create(Status  status) throws Exception {
        if(statusService.save(status)){
            return JsonResponse.success(status, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

