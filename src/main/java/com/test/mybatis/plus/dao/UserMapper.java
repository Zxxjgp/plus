package com.test.mybatis.plus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.test.mybatis.plus.entity.SysUser;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.utils.Page;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> getList(Page page);
    SysUser findByUserName(String username);
}