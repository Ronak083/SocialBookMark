package dao;

import Main.DataStore;
import Entity.Bookmark;
import Entity.userBookmark;

public class bookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(userBookmark usrBookmark) {
        DataStore.add(usrBookmark);
    }
}
