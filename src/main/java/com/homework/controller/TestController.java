package com.homework.controller;

import com.homework.pojo.Class;
import com.homework.service.ClassService;
import com.homework.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping("/check")
    public ModelAndView check(ModelAndView modelAndView,String str){
        if(!("kmcsb".equals(str))){
            modelAndView.setViewName("/pages/error.html");
            return modelAndView;
        }
//        System.out.println("-------------------");
        modelAndView.addObject("password","yes");
        modelAndView.setViewName("/pages/upload.html");

        return modelAndView;
    }

    @RequestMapping("/getClasses")
    public List<Class> getClasses(){
        List<Class> list = classService.list();
        return list;
    }
    @RequestMapping("/upload")
    public String upload(ModelAndView modelAndView, String classroom, String cName, int id, MultipartFile file, HttpServletRequest req) throws IOException {
        String realPath = "/usr/homework/"+classroom+"/"+cName;
//        System.out.println("-------------------------------");
        System.out.println(realPath);
        File folder = new File(realPath);
        if(!folder.exists())
            folder.mkdir();
        String oldName = file.getOriginalFilename();
        String newName = classroom+"_"+id+"_"+studentService.selectNameById(id)+"_"+cName+oldName.substring(oldName.lastIndexOf('.'));
        file.transferTo(new File(folder,newName));

        return "<h1>提交成功!!!</h1>";
    }
}
