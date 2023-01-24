package Main;

import Controllers.BookmarkController;
import Entity.Bookmark;
import Entity.User;


public class view {
    public static void bookmark(User user, Bookmark[][] bookmarks ) {
        System.out.println("\n" + user.getEmail() + " is Bookmarking");
        for (int i = 0 ; i< DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOff = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOff = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark =  bookmarks[typeOff][bookmarkOff];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
            System.out.println(bookmark);
        }
    }
}
