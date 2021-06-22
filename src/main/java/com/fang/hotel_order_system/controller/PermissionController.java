package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.entity.Permission;

import java.util.List;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionService permissionService;

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<Permission> permissionList = permissionService.list();
        return JsonResponse.success(permissionList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<Permission> page = new Page<>(current, size);
        permissionService.page(page);
        return JsonResponse.success(page);
    }

    @GetMapping("/roleId/{roleId}")
    public JsonResponse getListByRoleId(@PathVariable Long roleId) throws Exception {
        List<Permission> permissionList = permissionService.listByRoleId(roleId);
        return JsonResponse.success(permissionList);
    }
    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        Permission permission = permissionService.getById(id);
        return JsonResponse.success(permission);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if (permissionService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByPermissionId(Permission permission) throws Exception {
        if (permissionService.updateById(permission)) {
            return JsonResponse.success(permission, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
     * 描述:创建Permission
     */
    @PostMapping("")
    public JsonResponse create(Permission permission) throws Exception {
        if (permissionService.save(permission)) {
            return JsonResponse.success(permission, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }


    }
}

