package com.fang.hotel_order_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.hotel_order_system.entity.JwtUser;
import com.fang.hotel_order_system.entity.Role;
import com.fang.hotel_order_system.entity.dto.RegisterDto;
import com.fang.hotel_order_system.entity.vo.UserVo;
import com.fang.hotel_order_system.service.MailService;
import com.fang.hotel_order_system.service.RoleService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import com.fang.hotel_order_system.service.UserService;
import com.fang.hotel_order_system.entity.User;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 前端控制器
 *
 * @author fang
 * @version v1.0
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MailService mailService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取当前用户信息
     */
    @GetMapping("/info")
    public JsonResponse getCurrentUserInfo() throws Exception {
        JwtUser jwtUser = (JwtUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user = userService.getById(jwtUser.getUser().getUserId());
        List<Role> roleList = roleService.ListByUserId(user.getUserId());

        UserVo userVo=new UserVo();
        userVo.setUserId(user.getUserId());
        userVo.setUsername(user.getUsername());
        userVo.setPhone(user.getPhone());
        userVo.setEmail(user.getEmail());
        userVo.setNickname(user.getNickname());
        userVo.setCreateTime(user.getCreateTime());
        userVo.setIcon(user.getIcon());
        userVo.setRoleList(roleList);
        return JsonResponse.success(userVo);
    }

    /**
     * 描述：查询整个列表
     */
    @GetMapping("")
    public JsonResponse getList() throws Exception {
        List<UserVo> userVoList = userService.listUserVo();
        return JsonResponse.success(userVoList);
    }

    /**
     * 描述：查询整个列表,并分页
     */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current, @PathVariable long size) throws Exception {
        Page<UserVo> page = new Page<>(current, size);
        userService.pageUserVo(page);
        return JsonResponse.success(page);
    }

    /**
     * 描述：根据Id 查询
     */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        User user = userService.getById(id);
        return JsonResponse.success(user);
    }

    /**
     * 描述：根据Id删除
     */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if (userService.removeById(id)) {
            return JsonResponse.successMessage("删除成功！");
        } else {
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
     * 描述：根据Id 更新
     */
    @PutMapping("")
    public JsonResponse updateByUserId(User user) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.updateById(user)) {
            return JsonResponse.success(user, "修改成功！");
        } else {
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
     * 描述:创建User
     */
    @PostMapping("")
    public JsonResponse create(User user) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.save(user)) {
            return JsonResponse.success(user, "添加成功！");
        } else {
            return JsonResponse.failure("添加失败！");
        }
    }

    /**
     * 描述:注册
     */
    @PostMapping("/register")
    public JsonResponse register(RegisterDto registerDto) throws Exception {
        int count;

        // 验证用户名是否注册
        count = userService.count(new QueryWrapper<User>().eq("username", registerDto.getUsername()));
        if (count != 0) {
            return JsonResponse.failure("该用户名已注册！");
        }

        // 验证邮箱是否注册
        count = userService.count(new QueryWrapper<User>().eq("email", registerDto.getEmail()));
        if (count != 0) {
            return JsonResponse.failure("该邮箱已注册！");
        }

        // 验证手机号是否注册
        count = userService.count(new QueryWrapper<User>().eq("phone", registerDto.getPhone()));
        if (count != 0) {
            return JsonResponse.failure("该手机号已注册！");
        }

        //验证验证码是否正确
        String verifyCode = (String) redisTemplate.opsForValue().get(registerDto.getEmail() + ".verifyCode");
        if (verifyCode == null) {
            return JsonResponse.failure("验证码失效，请重试！");
        } else if (!verifyCode.equals(registerDto.getVerifyCode())) {
            return JsonResponse.failure("验证码错误！");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setNickname(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPhone(registerDto.getPhone());
        user.setPassword(registerDto.getPassword());
        if (userService.save(user)) {
            return JsonResponse.success(registerDto, "注册成功！");
        } else {
            return JsonResponse.failure("注册失败！");
        }
    }

    @GetMapping("/sendVerifyCode")
    public JsonResponse sendVerifyCode(String email) {
        int verifyNumber = RandomUtils.nextInt(100000, 1000000);
        String verifyCode = String.valueOf(verifyNumber);
        mailService.sendVerifyCode(email, verifyCode);
        redisTemplate.opsForValue().set(email + ".verifyCode", verifyCode, 60*5, TimeUnit.SECONDS);
        return JsonResponse.successMessage("验证码已发送！");
    }

}

