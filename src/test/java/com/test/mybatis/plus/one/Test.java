package com.test.mybatis.plus.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.one
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/25 16:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/25 16:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("周星驰");

        List<Suo> list = new ArrayList<>(16);

        list.add(new Suo("花花"));
        list.add(new Suo("曹操"));
        person.setLaopo(list);

        for ( Suo s : person.getLaopo()) {
            System.out.println(s.getLaopo());
        }
    }
}
