package com.company.jdbc;

import java.sql.*;

public class PerpareStatement {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456789");
            String sql = "select * from Student where sname = ? and id = ?";
            String sql1 = " Update student set sage = 18 where id = 2 ";
            String sql2 = "insert into student value('20200005','dragon','19','2','100')";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,"tony");
            preparedStatement.setInt(2,1);
            rs = preparedStatement.executeQuery();

            while (rs.next()){  //循环一次，游标移动一行
                System.out.println("id：" + rs.getString(1)); //  获取第一列的数据
                System.out.println("name：" + rs.getString(2));  //获取字段为name的数据
                System.out.println("age：" + rs.getInt(3)); //  获取第三列的数据
                System.out.println("grade：" + rs.getInt(4));
                System.out.println("score：" + rs.getInt(5)); //  获取第四列的数据
                System.out.println("-------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            assert con != null;
            con.close();
            assert rs != null;
            rs.close();
            preparedStatement.close();

        }
    }
}
