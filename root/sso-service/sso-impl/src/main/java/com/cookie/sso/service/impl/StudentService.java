package com.cookie.sso.service.impl;

import com.cookie.framework.base.BaseService;
import com.cookie.sso.mapper.StudentMapper;
import com.cookie.sso.model.Student;
import com.cookie.sso.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "student")
public class StudentService extends BaseService<Student> {
    @Autowired
    private StudentMapper studentMapper;
    public void save(){
        Student student = new Student();
        student.setUsername("danna");
        studentMapper.insert(student);
    }

    @Cacheable(key = "'S_NAME_'+#id" )
    public String getName(Integer id){
        StudentVO student = null;
        student = studentMapper.findSById(id);
        return student.getName();
    }
}
