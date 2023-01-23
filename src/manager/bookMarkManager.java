package manager;

import Entity.*;
import dao.bookmarkDao;

public class bookMarkManager {
    private static bookMarkManager instance = new bookMarkManager();
    private static bookmarkDao dao = new bookmarkDao();
    public Bookmark[][] getBookmarkDao(){
        return dao.getBookmarks();
    }
    private bookMarkManager(){}
    public static bookMarkManager getInstance(){
        return instance;
    }
    public Movie createMovie(long id, String title, String profileURL, int releaseYear,String[] cast,String[] direction,String genre, double imbdRating){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileURL(profileURL);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirection(direction);
        movie.setGenre(genre);
        movie.setImbdRating(imbdRating);
        return movie;
    }

    public Book createBook(long id, String title, String profileURL, int publicationYear, String publisher, String[] author, String genre, double amazonRating){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);
        return book;
    }

    public webLink createLink(long id, String title, String profileURL,String url,String host){
        webLink link = new webLink();
        link.setId(id);
        link.setTitle(title);
        link.setUrl(url);
        link.setHost(host);
        return link;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        userBookmark usrBookmark = new userBookmark();
        usrBookmark.setUser(user);
        usrBookmark.setBookmark(bookmark);

        dao.saveUserBookmark(usrBookmark);
    }
}
