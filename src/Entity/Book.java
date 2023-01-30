package Entity;

import Constants.bookGenre;
import org.junit.platform.commons.util.StringUtils;
import partner.Shareable;

import java.util.Arrays;

public  class Book extends Bookmark implements Shareable {
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book {" +
                "publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", author=" + Arrays.toString(author) +
                ", genre='" + genre + '\'' +
                ", amazonRating=" + amazonRating +
                '}';
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    private int publicationYear;
    private String publisher;
    private String[] author;
    private String genre;
    private double amazonRating;
    public boolean isKidFriendly(){
        if (genre.equals(bookGenre.PHILOSOPHY) || genre.equals(bookGenre.SELFHELP)){
            return false;
        }
        return true;
    }
    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Book</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        //builder.append("<author>").append(StringUtils.join(author, ",")).append("</author>");
        builder.append("<publisher>").append(publisher).append("</publisher>");
        builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
        builder.append("<genre>").append(genre).append("</genre>");
        builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
        builder.append("</item>");
        return builder.toString();
    }
}
