package com.fang.hotel_order_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.UserRoleService;
import com.fang.hotel_order_system.entity.UserRole;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author fang
 * @since 2021-06-17
 * @version v1.0
 */
@RestController
@RequestMapping("/api/userRole")
public class UserRoleController {

    private final Logger logger = LoggerFactory.getLogger( UserRoleController.class );

    @Autowired
    private UserRoleService userRoleService;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<UserRole> userRoleList =  userRoleService.list();
        return JsonResponse.success(userRoleList);
    }
    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        UserRole userRole =  userRoleService.getById(id);
        return JsonResponse.success(userRole);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(userRoleService.removeById(id)){
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
    public JsonResponse updateByIdUserRole(UserRole  userRole) throws Exception {
        if(userRoleService.updateById(userRole)){
            return JsonResponse.success(userRole, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建UserRole
    *
    */
    @PostMapping("")
    public JsonResponse create(UserRole  userRole) throws Exception {
        if(userRoleService.save(userRole)){
            return JsonResponse.success(userRole, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

