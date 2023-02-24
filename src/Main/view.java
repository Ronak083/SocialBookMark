package Main;
import Constants.KidFriendlyStatus;
import Constants.userType;
import Controllers.BookmarkController;
import Entity.Bookmark;
import Entity.User;
import partner.Shareable;

import java.util.List;


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

    public static void browse(User user, List<List<Bookmark>> bookmarks ) {
        System.out.println("\n" + user.getEmail() + " is browsing items....");

        for (List<Bookmark> bookmarkList : bookmarks){
            for(Bookmark bookmark : bookmarkList){
                //if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isbookmarked = getBookmarkDecision(bookmark);
                    if (isbookmarked){
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New item Bookmarked- " + bookmark);
                    }
                //}

                if (user.getusertype().equals(userType.EDITOR)  || user.getusertype().equals(userType.CHIEF_EDITOR)){
                    //Mark as kid-friendly
                    if (bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
                        }
                    }
                    //Sharing
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)&& bookmark instanceof Shareable   ){
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user,bookmark);
                        }
                    }
                }
            }
        }
    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {

        return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED : (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN ;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true: false;
    }
}
