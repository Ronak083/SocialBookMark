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

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;

    private static User[] users = new User[TOTAL_USER_COUNT];
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static userBookmark[] userBookmarks = new userBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    private static int bookmarkIndex;

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }


    public static User[] getUsers() {
        return users;
    }

    public static void loadData() {
        loadUser();
        loadWeblink();
        loadmovie();
        loadbook();
    }

    private static void loadbook() {
        /*bookmarks[2][0] = bookMarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, bookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = bookMarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", "", 1993, "Dover Publications", new String[]{"Ralph Waldo Emerson"}, bookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = bookMarkManager.getInstance().createBook(4002, "Light From Many Lamps", "", 1988, "Touchstone	Lillian", new String[]{" Eichler Watson"}, bookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = bookMarkManager.getInstance().createBook(4003, "Head First Design Patterns", "", 2004, "Reilly Media", new String[]{"Eric Freeman,Bert Bates,Kathy Sierra,Elisabeth Robson"}, bookGenre.FICTION, 4.5);
        bookmarks[2][4] = bookMarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", "", 2007, "Prentice Hall", new String[]{"Joshua Bloch"}, bookGenre.TECHNICAL, 4.9);
        */
        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "Book");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            String[] authors = values[4].split(",");
            bookmarks[2][colNum++] = bookMarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1] ,"",Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
        }
    }

    private static void loadmovie() {
        /*bookmarks[1][0] = bookMarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles,Joseph Cotten"}, new String[]{"Orson Welles"}, movieGenre.CLASSICS, 8.5);
        bookmarks[1][1] = bookMarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940, new String[]{"Henry Fonda,Jane Darwell"}, new String[]{"John Ford"}, movieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = bookMarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "", 2004, new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivan"}, movieGenre.DOCUMENTARIES, 7.3);
        bookmarks[1][3] = bookMarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007, new String[]{"Kaley Cuoco,Jim Parsons"}, new String[]{"	Chuck Lorre,Bill Prady"}, movieGenre.TV_SHOWS, 8.7);
        bookmarks[1][4] = bookMarkManager.getInstance().createMovie(3004, "Ikiru", "", 1952, new String[]{"Takashi Shimura,Minoru"}, new String[]{" Chiaki	Akira Kurosawa"}, movieGenre.FOREIGN_MOVIES, 8.4);
        */
        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "Movie");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            String[] cast = values[3].split(",");
            String[] directors = values[4].split(",");
            bookmarks[1][colNum++] = bookMarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
        }
    }

    private static void loadWeblink() {
        /*bookmarks[0][0] = bookMarkManager.getInstance().createLink(2000, "TamingTiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "");
        bookmarks[0][1] = bookMarkManager.getInstance().createLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com", "");
        bookmarks[0][2] = bookMarkManager.getInstance().createLink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com", "");
        bookmarks[0][3] = bookMarkManager.getInstance().createLink(2003, "NIO tutorial by Greg Travis", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu", "");
        bookmarks[0][4] = bookMarkManager.getInstance().createLink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org", "");
        */
        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "WebLink");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            bookmarks[0][colNum++] = bookMarkManager.getInstance().createLink(Long.parseLong(values[0]), values[1], "",values[2], values[3]/*, values[4]*/);
        }
    }


    private static void loadUser() {
        /* users[0] = userManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "Ronak", "Gupta", Gender.MALE, userType.USER);
        users[1] = userManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "John", "Bairstrow", Gender.MALE, userType.USER);
        users[2] = userManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Sam", "Gill", Gender.MALE, userType.EDITOR);
        users[3] = userManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Kane", "Bhai", Gender.MALE, userType.EDITOR);
        users[4] = userManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Angela", "Yu", Gender.FEMALE, userType.CHIEF_EDITOR);
    */
        String[] data = new String [TOTAL_USER_COUNT];
        IOUtil.read(data,"User");
        int rowNum = 0;
        for (String row : data ){
            String[] values = row.split("\t");

            int gender = Gender.MALE;
            if(values[5].equals("f")){
                gender = Gender.FEMALE;
            } else if(values[5].equals("t")){
                gender = Gender.TRANSGENDER;
            }

            users[rowNum++] = userManager.getInstance().createUser(Long.parseLong(values[0]), values[1],values[2],values[3], values[4],gender, values[6]);
        }
    }

    public static void add(userBookmark usrBookmark) {
        userBookmarks[bookmarkIndex] = usrBookmark;
        bookmarkIndex++;
    }
}

