package Main;
import Entity.Bookmark;
import Entity.User;
import manager.userManager;
import manager.bookMarkManager;
import java.util.List;
public class Launch {
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;
    private static void loadData() {
        System.out.println("1. Loading Main......");
        DataStore.loadData();
        users = userManager.getInstance().getUsers();
        bookmarks = bookMarkManager.getInstance().getBookmarkDao();
    }
    private static void printUserData() {
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println();
    }
    private static void printBookmarkData() {
        for (List<Bookmark> blist : bookmarks) {
            for (Bookmark bm : blist) {
                System.out.println(bm);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        loadData();
        start();
    }
    private static void start() {
        //System.out.println("\n2. Bookmarking......");
        for (User user : users){
            view.browse(user, bookmarks);
        }
    }
}
