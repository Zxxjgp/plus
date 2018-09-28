package com.test.mybatis.plus.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangyibo on 17/1/17.
 */

public class SysUser implements UserDetails {
    private Integer id;
    private String username;
    private String password;

    private List<SysRole> roles;
    private List<? extends GrantedAuthority> authoriti;

    public List<? extends GrantedAuthority> getAuthoriti() {
        return authoriti;
    }

    public void setAuthoriti(List<? extends GrantedAuthority> authoriti) {
        this.authoriti = authoriti;
    }

    public SysUser(List<? extends GrantedAuthority> authoriti) {
        this.authoriti = authoriti;
    }

    public SysUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authoriti = new HashSet<>();
        if (roles != null && roles.size() > 0) {
            roles.forEach(role -> {
                authoriti.add(new SimpleGrantedAuthority(role.getName()));
            });
        }
        return authoriti;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public static void main(String[] args) {
        String password ="123456";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }

    public SysUser(String username, String password, List<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authoriti = authorities;
    }
}
