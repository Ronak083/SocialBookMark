package dao;

import Entity.User;
import static Main.DataStore.getUsers;

public class userDao {
    public User[] getUser(){
        return getUsers();
    }
}
