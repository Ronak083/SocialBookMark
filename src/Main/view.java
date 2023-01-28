package Main;
import Constants.KidFriendlyStatus;
import Constants.userType;
import Controllers.BookmarkController;
import Entity.Bookmark;
import Entity.User;


public class view {
    /*public static void bookmark(User user, Bookmark[][] bookmarks ) {
        System.out.println("\n" + user.getEmail() + " is Bookmarking");
        for (int i = 0 ; i< DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOff = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOff = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark =  bookmarks[typeOff][bookmarkOff];
            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
            System.out.println(bookmark);
        }
    }*/

    public static void browse(User user, Bookmark[][] bookmarks ) {
        System.out.println("\n" + user.getEmail() + " is browsing items....");

        int bookmarkCount = 0;
        for (Bookmark[] bookmarkList : bookmarks){
            for(Bookmark bookmark : bookmarkList){
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isbookmarked = getBookmarkDecision(bookmark);
                    if (isbookmarked){
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New item Bookmarked- " + bookmark);
                    }
                }
                //Mark as kid-friendly
                if (user.getusertype().equals(userType.EDITOR)  || user.getusertype().equals(userType.CHIEF_EDITOR)){
                    if (bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if(kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            bookmark.setKidFriendlyStatus(kidFriendlyStatus);
                            System.out.println("Kid-friendly Status:" + kidFriendlyStatus + " , " + bookmark);
                        }
                    }
                }
            }
        }
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random();
        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED : (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN ;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true: false;
    }
}
