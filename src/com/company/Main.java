package com.company;

import java.sql.*;


public class Main {

    public static void main(String[] args)  {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456789");
            String sql = "select * from Student";
            String sql1 = " Update student set sage = 18 where id = 2 ";
            String sql2 = "insert into student value('20200005','dragon','19','2','100')";
            stat = con.createStatement();
            //stat.execute(sql2);
            stat.executeUpdate(sql1);
            rs = stat.executeQuery(sql);
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

            if (con != null){   //避免空指针异常
                //7、释放资源
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat != null){  //避免空指针异常
                //7、释放资源
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){  //避免空指针异常
                //7、释放资源
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


