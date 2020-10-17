package com.example.hacaton2020.Entity;

public class User {

    private String name;
    private String surname;
    private String middleName;
    private String login;
    private String password;

    public User(){
        name = "";
        surname = "";
        middleName = "";
        login = "";
        password = "";
    }

    public User(String name, String surname, String middleName, String login, String password){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
