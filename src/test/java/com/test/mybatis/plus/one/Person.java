package com.test.mybatis.plus.one;

import java.util.List;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.one
 * @ClassName: Person
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/25 16:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/25 16:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Person {
    private String name ;

    private List<Suo> laopo;

    public List<Suo> getLaopo() {
        return laopo;
    }

    public void setLaopo(List<Suo> laopo) {
        this.laopo = laopo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
