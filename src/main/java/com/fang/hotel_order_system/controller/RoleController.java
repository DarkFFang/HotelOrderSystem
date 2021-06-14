package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.RoleService;
import com.fang.hotel_order_system.entity.Role;


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
@RequestMapping("/api/role")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger( RoleController.class );

    @Autowired
    private RoleService roleService;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Role  role =  roleService.getById(id);
        return JsonResponse.success(role);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        roleService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse updateRole(@PathVariable("id") Long  id,Role  role) throws Exception {
        role.setRoleId(id);
        roleService.updateById(role);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Role
    *
    */
    @PostMapping("")
    public JsonResponse create(Role  role) throws Exception {
        roleService.save(role);
        return JsonResponse.success(null);
    }
}

