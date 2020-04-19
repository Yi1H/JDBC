package com.lyh1.test;

import com.lyh1.util.DaoUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;


public class BlobTest {
    public static void main(String[] args) throws Exception {
        //从数据库中获取图片
        Connection conn = DaoUtil.getConn();
        String sql = "select * from stu where id = ?";
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            Blob img = rs.getBlob("img");
            InputStream bs = img.getBinaryStream();
            Files.copy(bs, Paths.get("d://test.png"));
        }
        DaoUtil.Daoclose(rs,ps,conn);
    }
    void write() throws Exception {
        //往数据库中插入图片
        Connection conn = DaoUtil.getConn();
        String sql = "insert into stu(img) values(?)";
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql);
        FileInputStream file = new FileInputStream("f://code/1.jpg");
        ps.setBlob(1,file);
        ps.executeUpdate();

        DaoUtil.Daoclose(null,ps,conn);
    }
}
