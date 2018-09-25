package com.test.mybatis.plus.service.impl;


import com.test.mybatis.plus.dao.PermissionMapper;
import com.test.mybatis.plus.dao.UserMapper;
import com.test.mybatis.plus.entity.Permission;
import com.test.mybatis.plus.entity.SysRole;
import com.test.mybatis.plus.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Resource
    UserMapper userDao;
    @Resource
    PermissionMapper permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}



/*@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Resource
    UserMapper userDao;

    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        SysUser user = userDao.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。..
            System.out.println(user.getRoles());


        for (SysRole sysRole : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
            System.out.println(sysRole.getName());
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);

    }

}*/
