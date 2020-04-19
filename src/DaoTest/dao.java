package DaoTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dao {
    public static void save(student stu){
        //运用jdbc执行dml，dcl操作
        String url = "jdbc:mysql://localhost/jdbc";
        String user = "root";
        String pass = "123456";
        Statement stm = null;
        Connection conn = null;

        try{
            //加载类驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立于数据库的连接，传入url，user，password参数
            conn = DriverManager.getConnection(url,user,pass);
            //获取数据
            Integer age = stu.getAge();
            Integer id = stu.getId();
            String name = stu.getName();
            //创建sql语句
            stm = conn.createStatement();
            String sql = "insert into stu values("+id+",'"+name+"',"+age+")";
            System.out.println(sql);
            //执行sql语句
            int row = stm.executeUpdate(sql);
            System.out.println(row);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try{
                if (stm != null){
                    stm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
