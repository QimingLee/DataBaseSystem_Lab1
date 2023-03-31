package com.example.demo.controller;

import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.service.search;

@RestController
@RequiredArgsConstructor
public class Controller {
    public String dataBaseName;

    @RequestMapping("/search/condition")
    public List<Student> SearchByConditon(String SQLrequest,String dataBaseName){

        Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        List list = new ArrayList<>();
        try {
            list = student.SearchByConditon(SQLrequest);
            //list = search.SearchByConditon(SQLrequest,dataBaseName);
        } catch (Exception e){

            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping("/search/searchAll")
    public List SearchAllByConditon(String SQLrequest,String dataBaseName){

        //Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        List list = new ArrayList<>();
        try {
            //list = student.SearchByConditon(SQLrequest);
            list = search.SearchByConditon(SQLrequest,dataBaseName);
        } catch (Exception e){

            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("/search/searchAll2")
    public Map<String, Object> SearchAllByConditon2(String SQLrequest, String dataBaseName){

        //Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        Map<String, Object> map = new HashMap<>();
        try {
            //list = student.SearchByConditon(SQLrequest);
            map = search.SearchByConditon2(SQLrequest);
        } catch (Exception e){

            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/search/dataBaseName")
    public String setDataBaseName(){
        return this.dataBaseName;
    }
}
