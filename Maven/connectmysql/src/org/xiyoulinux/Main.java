package org.xiyoulinux;

public class Main {

    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.startConnect();
        dbConnection.startConnect();
        dbConnection.getResult();
        dbConnection.stopConnect();
        dbConnection.stopConnect();
    }
}
