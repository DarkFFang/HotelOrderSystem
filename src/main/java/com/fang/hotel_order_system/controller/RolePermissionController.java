package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.RolePermissionService;
import com.fang.hotel_order_system.entity.RolePermission;


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
@RequestMapping("/api/rolePermission")
public class RolePermissionController {

    private final Logger logger = LoggerFactory.getLogger( RolePermissionController.class );

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        RolePermission  rolePermission =  rolePermissionService.getById(id);
        return JsonResponse.success(rolePermission);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        rolePermissionService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updateRolePermission(@PathVariable("id") Long  id,RolePermission  rolePermission) throws Exception {
        rolePermission.setRolePermissionId(id);
        rolePermissionService.updateById(rolePermission);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建RolePermission
    *
    */
    @PostMapping("")
    public JsonResponse create(RolePermission  rolePermission) throws Exception {
        rolePermissionService.save(rolePermission);
        return JsonResponse.success(null);
    }
}

