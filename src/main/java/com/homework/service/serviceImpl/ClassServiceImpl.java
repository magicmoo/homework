package com.homework.service.serviceImpl;

import com.homework.mapper.ClassMapper;
import com.homework.pojo.Class;
import com.homework.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    public List<Class> list() {
        List<Class> list = classMapper.selectAll();
        return list;
    }
}
