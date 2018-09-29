package com.test.mybatis.plus.service;

import com.test.mybatis.plus.easeypoi.StudentEntity;

import java.util.List;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.service.impl
 * @ClassName: StudentPoiService
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/28 17:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 17:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface StudentPoiService {
   List<StudentEntity> getList();
}
