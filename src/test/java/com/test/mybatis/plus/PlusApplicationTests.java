package com.test.mybatis.plus;

import com.test.mybatis.plus.dao.UserMapper;
import com.test.mybatis.plus.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.test.mybatis.plus.dao")
public class PlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test start------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        System.out.println(("----- selectAll method test end------"));
    }

    @Test
    public void contextLoads() {
    }

}
