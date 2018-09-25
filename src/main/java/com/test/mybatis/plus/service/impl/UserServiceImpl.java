package com.test.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.mybatis.plus.dao.UserMapper;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.service.UserService;
import com.test.mybatis.plus.utils.Page;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ProjectName: test
 * @Package: com.test.mybatis.plus.service.impl
 * @ClassName: UserServiceImpl
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/22 11:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/22 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public User selectOne(User user) {
        EntityWrapper<User> queryWrapper = new EntityWrapper<User>();
        queryWrapper.eq("id",user.getId());
        return super.selectOne(queryWrapper);
    }

    @Override
    public Page<User> getList(Page page) {
        List<User> list = baseMapper.getList(page);
        page.setList(list);
        page.setCurrent(page.getCount());
        return page;
    }
}
