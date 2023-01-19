package Data;

import Constants.Gender;
import Constants.movieGenre;
import Constants.userType;
import Entity.Bookmark;
import Entity.User;
import Entity.userBookmark;
import manager.bookMarkManager;
import manager.userManager;

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static User[] users = new User[TOTAL_USER_COUNT];
    private static userBookmark[] userBookmarks = new userBookmark[TOTAL_USER_COUNT*USER_BOOKMARK_LIMIT];

    public static void loadData(){
        loadUser();
        loadWeblink();
        loadmovie();
        loadbook();
    }

    private static void loadbook() {
    }

    private static void loadmovie() {
        bookmarks[1][0] = bookMarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles,Joseph Cotten"},new String[] {"Orson Welles"}, movieGenre.CLASSICS,8.5);
        bookmarks[2][0] = bookMarkManager.getInstance().createMovie(3001,"The Grapes of Wrath","",1940,new String[]{"Henry Fonda,Jane Darwell"},new String[]{"John Ford"}	,movieGenre.CLASSICS	,8.2);
        bookmarks[3][0] = bookMarkManager.getInstance().createMovie(3002,"A Touch of Greatness","",2004,new String[]{"Albert Cullum"},new String[]{"Leslie Sullivan"}	,movieGenre.DOCUMENTARIES	,7.3);
        bookmarks[4][0] = bookMarkManager.getInstance().createMovie(3003,"The Big Bang Theory",	"",2007,new String[]{"Kaley Cuoco,Jim Parsons"},new String[]{"	Chuck Lorre,Bill Prady"}	,movieGenre.TV_SHOWS	,8.7);
        bookmarks[5][0] = bookMarkManager.getInstance().createMovie(3004,"Ikiru","",1952,new String[]{"Takashi Shimura,Minoru"},new String[]{" Chiaki	Akira Kurosawa"}	,movieGenre.FOREIGN_MOVIES,8.4);

    }

    private static void loadWeblink() {
        bookmarks[0][0] = bookMarkManager.getInstance().createLink(2000,"TamingTiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com","");
        bookmarks[0][1] = bookMarkManager.getInstance().createLink(2001,"How do I import a pre-existing Java project into Eclipse and get up and running?","http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com","");
        bookmarks[0][2] = bookMarkManager.getInstance().createLink(2002,"Interface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html","http://mindprod.com","");
        bookmarks[0][3] = bookMarkManager.getInstance().createLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf","http://cs.brown.edu","");
        bookmarks[0][4] = bookMarkManager.getInstance().createLink(2004,"Virtual Hosting and Tomcat","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html","http://tomcat.apache.org","");
    }

    private static void loadUser(){
        users[0] = userManager.getInstance().createUser(1000,"user0@semanticsquare.com","test","Ronak",  "Gupta", Gender.MALE, userType.USER);
        users[1] = userManager.getInstance().createUser(1001	,"user1@semanticsquare.com","test","John","Bairstrow", Gender.MALE,userType.USER);
        users[3] = userManager.getInstance().createUser(1002,"user2@semanticsquare.com","test","Sam",  "Gill", Gender.MALE, userType.EDITOR);
        users[4] = userManager.getInstance().createUser(1003	,"user3@semanticsquare.com","test","Kane","Bhai", Gender.MALE,userType.EDITOR);
        users[5] = userManager.getInstance().createUser(1004	,"user4@semanticsquare.com","test","Angela","Yu", Gender.FEMALE,userType.CHIEF_EDITOR);
    }

}
