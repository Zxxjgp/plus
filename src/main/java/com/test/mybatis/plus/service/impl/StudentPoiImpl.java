package com.test.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.mybatis.plus.dao.StudentEasyPoiMapper;
import com.test.mybatis.plus.easeypoi.StudentEntity;
import com.test.mybatis.plus.service.StudentPoiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: plus
 * @Package: com.test.mybatis.plus.service.impl
 * @ClassName: StudentPoiImpl
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/28 17:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/28 17:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class StudentPoiImpl implements StudentPoiService {

    @Resource
    private StudentEasyPoiMapper studentEasyPoiMapper;

    @Override
    public List<StudentEntity> getList() {
        return studentEasyPoiMapper.getList();
    }
}
