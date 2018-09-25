package com.test.mybatis.plus.service;
import com.baomidou.mybatisplus.service.IService;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.utils.Page;

import java.util.List;

/**
 * @ProjectName: test
 * @Package: com.test.mybatis.plus.service
 * @ClassName: UserService
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/22 11:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/22 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserService extends IService<User> {
    User selectOne(User user);
    Page<User> getList(Page page);
}
