package com.jsu.bean;

public class Address {
    private int id;
    private int uid;
    private String name;
    private String postalCode;
    private String detailAddress;
    private String addressSf;
    private String addressCs;
    private String addressQx;
    private int choice = -1; //1 为默认 0 为非默认 -1 未设置(用于动态sql)
    private String tel;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getAddressSf() {
        return addressSf;
    }

    public void setAddressSf(String addressSf) {
        this.addressSf = addressSf;
    }

    public String getAddressCs() {
        return addressCs;
    }

    public void setAddressCs(String addressCs) {
        this.addressCs = addressCs;
    }

    public String getAddressQx() {
        return addressQx;
    }

    public void setAddressQx(String addressQx) {
        this.addressQx = addressQx;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", addressSf='" + addressSf + '\'' +
                ", addressCs='" + addressCs + '\'' +
                ", addressQx='" + addressQx + '\'' +
                ", choice=" + choice +
                ", tel='" + tel + '\'' +
                '}';
    }
}
