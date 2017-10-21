package com.example.management;

/**
 * Created by 이동헌 on 2017-10-20.
 */

public class User {

    String userID;
    String userPassword;
    String userName;
    String userStudentnumber;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStudentnumber() {
        return userStudentnumber;
    }

    public void setUserStudentnumber(String userStudentnumber) {
        this.userStudentnumber = userStudentnumber;
    }

    public User(String userID, String userPassword, String userName, String userStudentnumber) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userStudentnumber = userStudentnumber;
    }
}
