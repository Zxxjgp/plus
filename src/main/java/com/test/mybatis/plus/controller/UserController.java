package com.test.mybatis.plus.controller;


import com.test.mybatis.plus.common.Constants;
import com.test.mybatis.plus.entity.User;
import com.test.mybatis.plus.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.test.mybatis.plus.utils.Page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: test
 * @Package: com.test.mybatis.plus.controller
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/22 13:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/22 13:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
/*@RestController*/
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    EntityWrapper<User> queryWrapper = new EntityWrapper<User>();




    @RequestMapping("list")
    public List<User> getUserList(){

        return userService.selectList(queryWrapper);
    }
 /*   @RequestMapping("page")
    public Page<User> getUserList(Page page){
        Page<User> pg = new Page<User>(1,3);

        return userService.selectPage(pg,queryWrapper);
    }*/

    @RequestMapping("pageList")
    public Page<User> getpageList(Page page){
        return userService.getList(page);
    }


    @RequestMapping("ll")
    public User get(User user){
        return userService.selectOne(user);
    }

    /**
     * 新增数据
     */
    @RequestMapping("save")
    public String save(User user){
        boolean b = userService.insertOrUpdate(user);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    /**
     * 数据的更新
     */
    @RequestMapping("update")
    public String update(User user){
        boolean b = userService.updateById(user);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    /**
     *数据的删除
     */
    @RequestMapping(value = "delete")
    public String delete(User user){
        Long id = user.getId();

        String str = "我是测试";
        System.out.println(str);
        EntityWrapper<User> q = new EntityWrapper<User>();

        q.eq("id",id);
        String strs = "我是测试sssssss";
        System.out.println(q);

        boolean b = userService.delete(q);
        if (b){
            return Constants.RESULT_SUCCESS;
        }
        else {
            return Constants.RESULT_FAIL;
        }
    }

    @RequestMapping("login")
    public String view(){
        return "login";
    }
}
