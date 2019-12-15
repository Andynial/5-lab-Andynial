package com.company;
import java.io.Serializable;

public class User implements Serializable {
    String name;
    String login;
    String password;

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
