package manager;

import Constants.KidFriendlyStatus;
import Constants.bookGenre;
import Constants.movieGenre;
import Entity.*;
import dao.bookmarkDao;
import util.HttpConnect;
import util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public class bookMarkManager {
    private static bookMarkManager instance = new bookMarkManager();
    private static bookmarkDao dao = new bookmarkDao();

    public List<List<Bookmark>> getBookmarkDao() {
        return dao.getBookmarks();
    }

    private bookMarkManager() {
    }

    public static bookMarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id, String title, String profileURL, int releaseYear, String[] cast, String[] direction, movieGenre genre, double imbdRating) {
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

    public Book createBook(long id, String title, String profileURL, int publicationYear, String publisher, String[] author, bookGenre genre, double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setProfileURL(profileURL);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);
        return book;
    }

    public webLink createLink(long id, String title, String profileURL, String url, String host) {
        webLink link = new webLink();
        link.setId(id);
        link.setTitle(title);
        link.setProfileURL(profileURL);
        link.setUrl(url);
        link.setHost(host);
        return link;
    }
    public List<List<Bookmark>> getBookmarks(){
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        userBookmark usrBookmark = new userBookmark();
        usrBookmark.setUser(user);
        usrBookmark.setBookmark(bookmark);
        /*if (bookmark instanceof webLink) {
            try {
                String url = ((webLink)bookmark).getUrl();
                if (!url.endsWith(".pdf")) {
                    String webpage = HttpConnect.download(((webLink)bookmark).getUrl());
                    if (webpage != null) {
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }*/
        dao.saveUserBookmark(usrBookmark);
    }

    public void setkidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlymarkBy(user);
        dao.updateKidFriendlyStatus(bookmark);

        System.out.println("Kid-friendly Status: " + kidFriendlyStatus + " Marked By: " + user.getEmail() + " , " + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
            bookmark.setSharedby(user);
            System.out.println("Data to be Shared: ");
            if (bookmark instanceof Book){
                System.out.println(((Book) bookmark).getItemData());
            } else if (bookmark instanceof webLink){
                System.out.println(((webLink) bookmark).getItemData());
            }
            dao.sharedByInfo(bookmark);
        }
}
