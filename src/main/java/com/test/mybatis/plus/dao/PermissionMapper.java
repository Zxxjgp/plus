package com.test.mybatis.plus.dao;


import com.test.mybatis.plus.entity.Permission;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PermissionMapper {
    List<Permission> findAll();
    List<Permission> findByAdminUserId(int userId);
}
