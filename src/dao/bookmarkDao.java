package dao;

import Data.DataStore;
import Entity.Bookmark;

public class bookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
}
