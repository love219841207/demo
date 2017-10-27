package com.cookie.sso.mapper;

import com.cookie.framework.base.MyMapper;
import com.cookie.sso.model.Student;
import com.cookie.sso.model.StudentVO;


public interface StudentMapper extends MyMapper<Student> {
    public StudentVO findSById(Integer id);
}
