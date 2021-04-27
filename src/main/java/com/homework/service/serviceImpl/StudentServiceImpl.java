package com.homework.service.serviceImpl;

import com.homework.mapper.StudentMapper;
import com.homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String selectNameById(int id) {
        return studentMapper.selectByPrimaryKey(id).getName();
    }
}
