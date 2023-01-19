package Data;

import Entity.Bookmark;
import Entity.User;
import manager.userManager;
import manager.bookMarkManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;
    private static void loadData(){
        System.out.println("Loading Data......");
        DataStore.loadData();
        users = userManager.getInstance().getUsers();
        bookmarks = bookMarkManager.getInstance().getBookmarkDao();
        System.out.println("Printing Data......");
        printUserData();
        printBookmarkData();
    }
    private static void printUserData(){
        for (User u: users){
            System.out.println(u);
        }
        System.out.println();
    }
    private static void printBookmarkData(){
        for (Bookmark[] blist : bookmarks){
            for (Bookmark bm: blist){
                System.out.println(bm);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        loadData();
    }
}
