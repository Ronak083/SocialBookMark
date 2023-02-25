package dao;
import Entity.webLink;
import Main.DataStore;
import Entity.Bookmark;
import Entity.userBookmark;
import java.util.ArrayList;
import java.util.List;

public class bookmarkDao {
    public List<List<Bookmark>> getBookmarks(){
        return DataStore.getBookmarks();
    }
    public void saveUserBookmark(userBookmark usrBookmark) {
        DataStore.add(usrBookmark);
    }
    public List<webLink> getAllWebLinks() {
        List<webLink> result = new ArrayList<>();
        List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
        List<Bookmark> allWebLinks = bookmarks.get(0);
        for (Bookmark bookmark: allWebLinks){
            result.add((webLink)bookmark);
        }
        return result;
    }
    public List<webLink> getWebLinks(webLink.DownloadStatus downloadStatus){
        List<webLink> result = new ArrayList<>();
        List<webLink> allWebLinks = getAllWebLinks()    ;
        for (webLink wl : allWebLinks){
            if(wl.getDownloadStatus().equals(downloadStatus)){
                result.add(wl);
            }
        }
        return result;
    }



}
