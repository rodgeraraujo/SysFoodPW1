package com.ifpb.pw1.sysfood.dao.connect;

public class DataBase {
    private String url;
    private String user;
    private String password;

    public DataBase() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/sysfood";
        this.user = "postgres";
        this.password = "123456";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
