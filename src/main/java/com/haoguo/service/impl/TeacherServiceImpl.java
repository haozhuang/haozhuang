package com.haoguo.service.impl;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2018-04-13
 * Time: AM 10:48
 */

import com.haoguo.mapper.TeacherMapper;
import com.haoguo.model.Teacher;
import com.haoguo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author zhuang.hao
 * @create 2018-04-13 AM 10:48
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public List<Teacher> getTeacherDesc() {

        return teacherMapper.getTeacherDesc();
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        int typenum = teacherMapper.insert(teacher);
        return typenum;
    }
}
