package com.example.hacaton2020.Entity;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;

    public Users(){
        users = new ArrayList<User>();
    }

    public Users(List<User> users){
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User searchByLoginAndPassword(String login, String password){

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin().equals(login)){
                if (users.get(i).getPassword().equals(password)){
                    return users.get(i);
                }
            }
        }
        return null;
    }
}
