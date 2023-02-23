package Main;

import Constants.Gender;
import Constants.bookGenre;
import Constants.movieGenre;
import Constants.userType;
import Entity.Bookmark;
import Entity.User;
import Entity.userBookmark;
import manager.bookMarkManager;
import manager.userManager;
import util.IOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DataStore {
    private static List<User> users = new ArrayList<>();
    private static List<List<Bookmark>> bookmarks = new ArrayList<>();
    private static List<userBookmark> userBookmarks = new ArrayList<>();
    public static List<List<Bookmark>> getBookmarks() {
        return bookmarks;
    }
    public static List<User> getUsers() {
        return users;
    }
    public static void loadData() {
        loadUser();
        loadWeblink();
        loadmovie();
        loadbook();
    }
    private static void loadbook() {
        List<String> data = new ArrayList<>();
        IOUtil.read(data, "Book");
        List<Bookmark> bookmarkList = new ArrayList<>();
        for (String row : data) {
            String[] values = row.split("\t");
            String[] authors = values[4].split(",");
            Bookmark bookmark = bookMarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1] ,"",Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    private static void loadmovie() {
        List<String> data = new ArrayList<>();
        IOUtil.read(data, "Movie");
        List<Bookmark> bookmarkList = new ArrayList<>();
        for (String row : data) {
            String[] values = row.split("\t");
            String[] cast = values[3].split(",");
            String[] directors = values[4].split(",");
            Bookmark bookmark = bookMarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    private static void loadWeblink() {
        List<String> data = new ArrayList<>();
        IOUtil.read(data, "WebLink");
        List<Bookmark> bookmarkList = new ArrayList<>();
        for (String row : data) {
            String[] values = row.split("\t");
            Bookmark bookmark = bookMarkManager.getInstance().createLink(Long.parseLong(values[0]), values[1], "",values[2], values[3]/*, values[4]*/);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    private static void loadUser() {
        List<String> data = new ArrayList<>();
        IOUtil.read(data,"User");
        for (String row : data ){
            String[] values = row.split("\t");

            int gender = Gender.MALE;
            if(values[5].equals("f")){
                gender = Gender.FEMALE;
            } else if(values[5].equals("t")){
                gender = Gender.TRANSGENDER;
            }

            User user = userManager.getInstance().createUser(Long.parseLong(values[0]), values[1],values[2],values[3], values[4],gender, values[6]);
            users.add(user);
        }
    }
    public static void add(userBookmark usrBookmark) {
        userBookmarks.add(usrBookmark);
    }
}

