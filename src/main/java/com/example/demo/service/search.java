package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Sc;
import com.example.demo.entity.Student;

import javax.jws.Oneway;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class search {
    public String dataBaseName_Global;
    public void setDataBaseName_Global(String dataBaseName_Global){
        this.dataBaseName_Global = dataBaseName_Global;
    }
    public String getDataBaseName_Global(){
        return this.dataBaseName_Global;
    }

    //Map<String, Object>
    public ArrayList SearchByConditon(String SQLrequest, String dataBaseName) throws ClassNotFoundException, SQLException {
        ArrayList list = new ArrayList<>();
        //1.注册驱动、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/sct";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);

        if(connection!=null){
            System.out.println("连接到数据库！"+ dataBaseName);
            dataBaseName_Global = dataBaseName;
        }else{
            System.out.println("连接失败！");
        }
        //3.获得执行SQL语句的对象
        Statement statement = connection.createStatement();
        //4.编写SQL语句，执行SQL语句
        String sql = SQLrequest;
        /*
        try{

            ResultSet result = statement.executeQuery(sql);
        }catch (SQLException e){

            e.printStackTrace();

        }*/
        ResultSet result = statement.executeQuery(sql);
        //根据数据库的内容分类
        int result_num = 0;
        if(dataBaseName.equals("Student")){
            while (result.next() && result_num<=500 ){
                String Snum = result.getString("Snum");
                String Sname = result.getString("Sname");
                String Ssex = result.getString("Ssex");
                Integer Sage = result.getInt("Sage");
                String SClass = result.getString("SClass");
                Student student = new Student(Snum,Sname,Ssex,Sage,SClass);
                list.add(student);
                result_num++;
            }
        } else if (dataBaseName.equals("Course")) {
            while (result.next() && result_num<=500){
                String Snum = result.getString("Cnum");
                String Sname = result.getString("Cname");
                double Ssex = result.getDouble("Credit");
                Integer Sage = result.getInt("Chours");
                String SClass = result.getString("Tnum");
                Course course = new Course(Snum,Sname,Ssex,Sage,SClass);
                list.add(course);
                result_num++;
            }
        } else if (dataBaseName.equals("SC")) {
            while(result.next()&& result_num<=500){
                String Snum = result.getString("Snum");
                String Cnum = result.getString("Cnum");
                double Score = result.getDouble("Score");
                Sc sc = new Sc(Snum,Cnum,Score);
                list.add(sc);
                result_num++;
            }
        } else{
            list = null;
        }

        //5.查看结果
        System.out.println(list);
        //6.释放资源，先开后关
        statement.close();
        connection.close();

        return list;
    }

    public Map<String, Object> SearchByConditon2(String SQLrequest) throws ClassNotFoundException, SQLException {

        Map<String, Object> resultMap = new HashMap<>();
        ArrayList list = new ArrayList<>();
        //1.注册驱动、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/sct";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);

        if(connection!=null){

            System.out.println("连接到数据库！");
        }else{

            System.out.println("连接失败！");
        }
        //3.获得执行SQL语句的对象
        Statement statement = connection.createStatement();
        //4.编写SQL语句，执行SQL语句
        String sql = SQLrequest;
        /*
        try{

            ResultSet result = statement.executeQuery(sql);
        }catch (SQLException e){

            e.printStackTrace();

        }*/
        ResultSet result = statement.executeQuery(sql);
        //根据数据库的内容分类

        ResultSetMetaData row = result.getMetaData();
        int r = row.getColumnCount();
        List<String> col = new ArrayList<>();
        for(int i=1; i<=r; i++){
            col.add(row.getColumnName(i));
        }
        List<String> colname = new ArrayList<>();
        for (String str : col) {
            if (!colname.contains(str)) {
                colname.add(str);
            }
        }
        System.out.println(colname);
        int result_num = 0;
        while (result.next()&&result_num<=500){

            Map<String, String> dataMap = new HashMap<>();
            for (String s : colname) {
                dataMap.put(s, result.getString(s));
            }
            list.add(dataMap);
            result_num++;
        }

        //5.查看结果
        System.out.println(list);
        //6.释放资源，先开后关
        statement.close();
        connection.close();

        resultMap.put("col", colname);
        resultMap.put("data", list);

        return resultMap;
    }
}
