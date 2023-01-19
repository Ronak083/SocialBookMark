package dao;

import Data.DataStore;
import Entity.User;
import static Data.DataStore.getUsers;

public class userDao {
    public User[] getUser(){
        return getUsers();
    }
}
