package dao;
import Entity.*;
import Main.DataStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class bookmarkDao {
    public List<List<Bookmark>> getBookmarks(){
        return DataStore.getBookmarks();
    }
    public void saveUserBookmark(userBookmark userBookmark) {
        //DataStore.add(userBookmark);
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA?useSSL=false","root","Rgupta083");
            Statement stmt = conn.createStatement()){
            if(userBookmark.getBookmark() instanceof Book){
                saveUserBook(userBookmark, stmt);
            } else if(userBookmark.getBookmark() instanceof webLink){
                saveUserWebLink(userBookmark, stmt);
            } else{
                saveUserMovie(userBookmark, stmt);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKidFriendlyStatus(Bookmark bookmark) {
        int kidFriendlyStatus = bookmark.getKidFriendlyStatus().ordinal();
        long userId = bookmark.getKidFriendlymarkBy().getId();

        String tableToUpdate = "Book";
        if(bookmark instanceof Movie) {
            tableToUpdate = "Movie";
        } else if(bookmark instanceof webLink) {
            tableToUpdate = "WebLink";
        }

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA?useSSL=false","root","Rgupta083");
            Statement stmt = conn.createStatement()){
            String query = "update "+ tableToUpdate + " set kid_friendly_status = "+ kidFriendlyStatus + ", kid_friendly_marked_by = "+ userId +" where id = "+ bookmark.getId();
            System.out.println("query (updateKidFriendlyStatus): "+ query);
            stmt.executeUpdate(query);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveUserWebLink(userBookmark userBookmark, Statement stmt) throws SQLException {
        String query = "insert into User_WebLink (user_id, weblink_id) values (" +
                userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId() + ")";
        stmt.executeUpdate(query);
    }

    private void saveUserMovie(userBookmark userBookmark, Statement stmt) throws SQLException {
        String query = "insert into User_Movie (user_id, movie_id) values (" +
                userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId() + ")";
        stmt.executeUpdate(query );
    }

    private void saveUserBook(userBookmark userBookmark, Statement stmt) throws SQLException {
        String query = "insert into User_Book (user_id, book_id) values (" + userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId() + ")";
        stmt.executeUpdate(query);
    }

    public List<webLink> getAllWebLinks() {
        List<webLink> result = new ArrayList<>();
        List<List<Bookmark>> bookmarks = getBookmarks();
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


    public void sharedByInfo(Bookmark bookmark) {
        String tableToUpdate = "Book";
        if(bookmark instanceof webLink) tableToUpdate = "WebLink";
        long userId = bookmark.getSharedby().getId();
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA?useSSL=false","root","Rgupta083");
            Statement stmt = conn.createStatement()){
            String query = "update "+ tableToUpdate + " set shared_by = "+ userId + " where id = "+ bookmark.getId();
            System.out.println("query (updateSharedBy): "+ query);
            stmt.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
