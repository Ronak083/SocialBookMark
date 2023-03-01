package Main;
import Constants.Gender;
import Constants.bookGenre;
import Constants.movieGenre;
import Constants.UserType;
import Entity.Bookmark;
import Entity.User;
import Entity.userBookmark;
import manager.bookMarkManager;
import manager.userManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA?useSSL=false","root","Rgupta083");
            Statement stmt = conn.createStatement();){
                   loadUsers(stmt);
                   loadWeblinks(stmt);
                   loadmovies(stmt);
                   loadbooks(stmt);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void loadUsers(Statement stmt) throws SQLException {
        String query = "Select * from User";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            long id = rs.getLong("id");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            Gender gender = Gender.values()[rs.getInt("gender_id")];
            UserType usertype = UserType.values()[rs.getInt("user_type_id")];

            User user = userManager.getInstance().createUser(id,email,password,firstname,lastname,gender,usertype);
            users.add(user);
        }
    }
    private static void loadWeblinks(Statement stmt) throws SQLException {
        String query = "Select * from WebLink";
        ResultSet rs = stmt.executeQuery(query);
        List<Bookmark> bookmarkList = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String title = rs.getString("title");
            String profileUrl = "-";
            String url = rs.getString("url");
            String host = rs.getString("host");
            Bookmark bookmark = bookMarkManager.getInstance().createLink(id, title, profileUrl,url,host/*, values[4]*/);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    private static void loadbooks(Statement stmt) throws SQLException {
        String query = "Select b.id, title, publication_year, p.name, GROUP_CONCAT(a.name SEPARATOR ',') AS authors, book_genre_id, amazon_rating, created_date " +
                "from Book b, Publisher p, Author a, Book_Author ba \n" +
                "where b.publisher_id = p.id and b.id = ba.book_id \n" +
                "and ba.author_id = a.id group by b.id";
                ResultSet rs = stmt.executeQuery(query);
        List<Bookmark> bookmarkList = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String title = rs.getString("title");
            int publicationYear = rs.getInt("publication_year");
            String publisher = rs.getString("name");
            String[] authors = rs.getString("authors").split(",");
            int genre_id = rs.getInt("book_genre_id");
            bookGenre genre = bookGenre.values()[genre_id];
            double amazonRating = rs.getDouble("amazon_rating");

            Date createdDate = rs.getDate("Created_date");
            System.out.println("createdDate: " + createdDate);
            Timestamp timestamp = rs.getTimestamp(8);
            System.out.println("timeStamp: " + timestamp);
            System.out.println("LocaltimeStamp: " + timestamp.toLocalDateTime());
            System.out.println("id: " + id + ", title: "+ title + ", publication year: " + publicationYear + ", publisher: " + publisher + ", authors" + authors + ", genre_id: " + genre_id +", genre: " + genre + ", amazonRating: "+ amazonRating);
            Bookmark bookmark = bookMarkManager.getInstance().createBook(id, title, "-",publicationYear, publisher, authors, genre,amazonRating /*, */);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    private static void loadmovies(Statement stmt) throws SQLException {
        String query = "Select m.id, title, release_year, GROUP_CONCAT(DISTINCT a.name SEPARATOR ',') AS cast, GROUP_CONCAT(DISTINCT d.name SEPARATOR ',') AS directors, movie_genre_id, imdb_rating"
                + " from Movie m, Actor a, Movie_Actor ma, Director d, Movie_Director md "
                + "where m.id = ma.movie_id and ma.actor_id = a.id and "
                + "m.id = md.movie_id and md.director_id = d.id group by m.id";
        ResultSet rs = stmt.executeQuery(query);
        List<Bookmark> bookmarkList = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String title = rs.getString("title");
            int releaseYear = rs.getInt("release_year");
            String[] cast = rs.getString("cast").split(",");
            String[] directors = rs.getString("directors").split(",");
            int genre_id = rs.getInt("movie_genre_id");
            movieGenre genre = movieGenre.values()[genre_id];
            double imdbRating = rs.getDouble("imdb_rating");

            Bookmark bookmark = bookMarkManager.getInstance().createMovie(id, title, "", releaseYear, cast, directors, genre, imdbRating/*, values[7]*/);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }
    public static void add(userBookmark usrBookmark) {
        userBookmarks.add(usrBookmark);
    }
}

