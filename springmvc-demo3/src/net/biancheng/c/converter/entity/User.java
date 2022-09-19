// 包说明：converter，数据转换器
package net.biancheng.c.converter.entity;

import java.util.Date;

public class User {

    private String userName;

    private Date birth;

    private Double height;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", height=" + height +
                ", birth=" + birth +
                '}';
    }
}
