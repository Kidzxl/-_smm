package com.jsu.bean;

public class UserInfo {
    private int id ;
    private int uid;
    private String name;
    private String nickname;
    private String sex;
    private String address_sf;
    private String address_cs;
    private String address_qx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress_sf() {
        return address_sf;
    }

    public void setAddress_sf(String address_sf) {
        this.address_sf = address_sf;
    }

    public String getAddress_cs() {
        return address_cs;
    }

    public void setAddress_cs(String address_cs) {
        this.address_cs = address_cs;
    }

    public String getAddress_qx() {
        return address_qx;
    }

    public void setAddress_qx(String address_qx) {
        this.address_qx = address_qx;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", address_sf='" + address_sf + '\'' +
                ", address_cs='" + address_cs + '\'' +
                ", address_qx='" + address_qx + '\'' +
                '}';
    }
}
