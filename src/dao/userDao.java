package dao;

import Entity.User;

import java.util.List;

import static Main.DataStore.getUsers;

public class userDao {
    public List<User> getUser(){
        return getUsers();
    }
}
