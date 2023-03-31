package com.example.demo;

import com.example.demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        SpringApplication.run(DemoApplication.class, args);
        //test
//        Student student = new Student();
//        student.InsertStudent("20022021","贾梓萌","女",21,"237011");
//        ArrayList<Student> list = new ArrayList<>();
//        Student student = new Student();
//        list = student.SearchAll();
//        System.out.println(list);
//        Student student = new Student();
//        String string = "SELECT * FROM STUDENT WHERE Sname = \"贾梓萌\";";
//        student.SearchByConditon(string);


    }

}
