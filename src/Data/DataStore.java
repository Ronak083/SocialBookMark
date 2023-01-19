package Data;

import Entity.Bookmark;
import Entity.User;
import Entity.userBookmark;

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    private static User[] users = new User[TOTAL_USER_COUNT];
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    public static final int USER_BOOKMARK_LIMIT = 5;
    private static userBookmark[] userBookmarks = new userBookmark[TOTAL_USER_COUNT];
}
