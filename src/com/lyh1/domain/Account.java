package com.lyh1.domain;

public class Account {
    Integer money;
    String name;
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
