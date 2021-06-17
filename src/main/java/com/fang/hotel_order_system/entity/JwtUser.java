package com.fang.hotel_order_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 类 {@code JwtUser 用户认证} .
 *
 * @author fang
 * @since 2020/12/14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtUser implements UserDetails {
    /**
     * 版本
     */
    private static final long serialVersionUID = 1L;

    private User user;
    /**
     * 权限
     */
    private Collection<? extends GrantedAuthority> authorities;
    /**
     *返回用户权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     *返回账号是否过期
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 返回账号是否锁定
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *返回用户凭证是否过期
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 返回是否可用
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
