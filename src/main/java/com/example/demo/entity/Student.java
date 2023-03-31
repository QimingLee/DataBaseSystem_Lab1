package com.example.demo.entity;

import java.io.Reader;
import java.io.Serializable;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;


/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private String snum;

    private String sname;

    private String ssex;

    private Integer sage;

    private String sclass;

    private static final long serialVersionUID = 1L;

    public Student(String snum, String sname, String ssex, int sage, String sClass) {
        this.snum = snum;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sclass = sClass;
    }

    public Student() {

    }

    public int InsertStudent(String Snum,String Sname,String Ssex,Integer Sage,String Sclass) throws ClassNotFoundException, SQLException, SQLException {
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
        String sql = "insert into Student(Snum,Sname,Ssex,Sage,SClass) values('" + Snum + "','"+ Sname +"','"+ Ssex +"','"+ Sage +"','"+ Sclass +"')";
        int result = statement.executeUpdate(sql);
        System.out.println(result);

        //5.处理结果
        if(result == 1){
            System.out.println("Success!");
        }else {
            System.out.println("Failure!");
        }

        //6.释放资源，先开后关
        statement.close();
        connection.close();

        return result;
    }

    public ArrayList<Student> SearchByConditon(String SQLrequest) throws ClassNotFoundException, SQLException {

        ArrayList<Student> list = new ArrayList<>();
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
        //System.out.println(dataBaseName);
        //System.out.println("学生");
        while (result.next()){
                String Snum = result.getString("Snum");
                String Sname = result.getString("Sname");
                String Ssex = result.getString("Ssex");
                Integer Sage = result.getInt("Sage");
                String SClass = result.getString("SClass");
                Student student = new Student(Snum,Sname,Ssex,Sage,SClass);
                list.add(student);
        }


        //5.查看结果
        System.out.println(list);
        //6.释放资源，先开后关
        statement.close();
        connection.close();

        return list;
    }

    public ArrayList<Student> SearchAll() throws ClassNotFoundException, SQLException {

        ArrayList<Student> list = new ArrayList<>();
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
        String sql = "SELECT * FROM student";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            String Snum = result.getString("Snum");
            String Sname = result.getString("Sname");
            String Ssex = result.getString("Ssex");
            Integer Sage = result.getInt("Sage");
            String SClass = result.getString("SClass");
            Student student = new Student(Snum,Sname,Ssex,Sage,SClass);
            list.add(student);
        }
        //System.out.println(result);

        //5.处理结果
//        if(!result.wasNull()){
//            System.out.println("Success!");
//        }else {
//            System.out.println("Failure!");
//        }

        //6.释放资源，先开后关
        statement.close();
        connection.close();

        return list;

    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getSnum() == null ? other.getSnum() == null : this.getSnum().equals(other.getSnum()))
            && (this.getSname() == null ? other.getSname() == null : this.getSname().equals(other.getSname()))
            && (this.getSsex() == null ? other.getSsex() == null : this.getSsex().equals(other.getSsex()))
            && (this.getSage() == null ? other.getSage() == null : this.getSage().equals(other.getSage()))
            && (this.getSclass() == null ? other.getSclass() == null : this.getSclass().equals(other.getSclass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSnum() == null) ? 0 : getSnum().hashCode());
        result = prime * result + ((getSname() == null) ? 0 : getSname().hashCode());
        result = prime * result + ((getSsex() == null) ? 0 : getSsex().hashCode());
        result = prime * result + ((getSage() == null) ? 0 : getSage().hashCode());
        result = prime * result + ((getSclass() == null) ? 0 : getSclass().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", snum=").append(snum);
        sb.append(", sname=").append(sname);
        sb.append(", ssex=").append(ssex);
        sb.append(", sage=").append(sage);
        sb.append(", sclass=").append(sclass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}