package JDBCconn;

import java.sql.*;

public class JDBC_dql {
    public static void main(String[] args) throws Exception{
        //运用JDBC执行DQL语句

        String url = "jdbc:mysql://localhost/jdbc";
        String user = "root";
        String pass = "123456";
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //建立数据库连接
        Connection conn = DriverManager.getConnection(url,user,pass);
        //创建statment对象，并传入sql语句和参数
        Statement stm = conn.createStatement();
        String sql = "select * from stu ";
        //执行sql语句并返回结果
        ResultSet res = stm.executeQuery(sql);
        //对结果集的处理
        System.out.println(res);

        //获取一条数据
//        if (res.next()){
//            int id = res.getInt("id");
//            String name = res.getString("name");
//            int age = res.getInt("age");
//            System.out.println(id+" "+ name + " " + age );
//        }

        //获取多条数据
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");
            System.out.println(id+" "+ name + " " + age );
        }

        //关闭资源
        stm.close();
        conn.close();
    }

}
