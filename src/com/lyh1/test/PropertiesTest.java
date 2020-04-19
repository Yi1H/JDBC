package com.lyh1.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {

        try {
            Properties p = new Properties();
            FileInputStream in = new FileInputStream("src/resource/db.properties");
            p.load(in);
            BasicDataSource bds = BasicDataSourceFactory.createDataSource(p);
            System.out.println(bds.getUsername());
            System.out.println(bds.getDriverClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
