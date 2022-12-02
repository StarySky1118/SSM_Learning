package com.zzy.DI.jdbc;

public class MyDataSource3 {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyDataSource3{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
