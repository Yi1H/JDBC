package com.lyh2.domain;

public class User {
    //msr映射User表
    String user;
    String pwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
