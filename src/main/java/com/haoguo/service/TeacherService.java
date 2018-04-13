package com.haoguo.service;

import com.haoguo.model.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA. 
 * Description: 
 * User: Administrator 
 * Date: 2018-04-13
 * Time: AM 10:47
 */
public interface TeacherService {

	List<Teacher> getTeacherDesc();

	int insertTeacher(Teacher teacher);
}
