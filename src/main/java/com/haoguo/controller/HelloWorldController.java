package com.haoguo.controller;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2018-04-13
 * Time: AM 10:36
 */

import com.haoguo.model.Teacher;
import com.haoguo.service.TeacherService;
import com.haoguo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author zhuang.hao
 * @create 2018-04-13 AM 10:36
 **/
@RestController
public class HelloWorldController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "HelloHAOZHUANG!!";
    }
    @RequestMapping("/getTeacher")
    public List<Teacher> getTeacher(){
        List<Teacher> tes = teacherService.getTeacherDesc();
        return  tes;
    }
    @RequestMapping("/addTeacher")
    public int tynume (@RequestParam(value = "addTeacher") String teacher){
        Teacher tea = JsonUtils.fromBean(teacher, Teacher.class);
        int tynume = teacherService.insertTeacher(tea);
        return tynume;
    }
}
