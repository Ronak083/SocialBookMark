package Controllers;

import Constants.KidFriendlyStatus;
import Entity.Bookmark;
import Entity.User;
import manager.bookMarkManager;

public class BookmarkController {
    private BookmarkController() {
    }

    private static BookmarkController instance = new BookmarkController();

    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        bookMarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
        bookMarkManager.getInstance().setkidFriendlyStatus(user, kidFriendlyStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookMarkManager.getInstance().share(user, bookmark);
    }
}
