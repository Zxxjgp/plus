package com.test.mybatis.plus.dao;


import com.test.mybatis.plus.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PermissionMapper {
    List<Permission> findAll();
    List<Permission> findByAdminUserId(int userId);
}
