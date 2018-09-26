package com.test.mybatis.plus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.test.mybatis.plus.entity.SysUser;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.utils.Page;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    List<User> getList(Page page);
    SysUser findByUserName(String username);

    List<SysUser> getByMap(Map<String, Object> map);
    List<SysUser> getByRoleId(Map<String, Object> map);
    SysUser getById(Integer id);
    Integer create(SysUser user);
    int update(SysUser user);
    SysUser getByUserName(String userName);
}