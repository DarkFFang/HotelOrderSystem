package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.entity.Permission;


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
@RequestMapping("/api/permission")
public class PermissionController {

    private final Logger logger = LoggerFactory.getLogger( PermissionController.class );

    @Autowired
    private PermissionService permissionService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Permission  permission =  permissionService.getById(id);
        return JsonResponse.success(permission);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        permissionService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updatePermission(@PathVariable("id") Long  id,Permission  permission) throws Exception {
        permission.setPermissionId(id);
        permissionService.updateById(permission);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Permission
    *
    */
    @PostMapping("")
    public JsonResponse create(Permission  permission) throws Exception {
        permissionService.save(permission);
        return JsonResponse.success(null);
    }
}

