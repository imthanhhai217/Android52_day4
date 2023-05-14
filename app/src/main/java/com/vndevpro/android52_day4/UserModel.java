package com.vndevpro.android52_day4;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String userName;
    private String passwords;
    private String address;
    private String email;

    public UserModel() {
    }

    public UserModel(String userName, String passwords, String address, String email) {
        this.userName = userName;
        this.passwords = passwords;
        this.address = address;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" + "userName='" + userName + '\'' + ", passwords='" + passwords + '\'' + ", address='" + address + '\'' + ", email='" + email + '\'' + '}';
    }
}
