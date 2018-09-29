package com.test.mybatis.plus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.test.mybatis.plus.easeypoi.StudentEntity;

import java.util.List;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.dao
 * @ClassName: StudentEasyPoiMapper
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/28 17:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 17:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface StudentEasyPoiMapper extends BaseMapper<StudentEntity> {
    List<StudentEntity> getList();
}
