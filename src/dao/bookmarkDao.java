package dao;

import Main.DataStore;
import Entity.Bookmark;
import Entity.userBookmark;

import java.util.List;

public class bookmarkDao {
    public List<List<Bookmark>> getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(userBookmark usrBookmark) {
        DataStore.add(usrBookmark);
    }
}
