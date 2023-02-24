package Entity;

import Constants.movieGenre;
import partner.Shareable;

import java.util.Arrays;

public class Movie extends Bookmark  {
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getDirection() {
        return direction;
    }

    public void setDirection(String[] direction) {
        this.direction = direction;
    }

    public movieGenre getGenre() {
        return genre;
    }

    public void setGenre(movieGenre genre) {
        this.genre = genre;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }

    private int releaseYear;
    private String[] cast;
    private String[] direction;
    private movieGenre genre;
    private double imbdRating;

    @Override
    public String toString() {
        return "Movie {" +
                "releaseYear=" + releaseYear +
                ", cast=" + Arrays.toString(cast) +
                ", direction=" + Arrays.toString(direction) +
                ", genre='" + genre + '\'' +
                ", imbdRating=" + imbdRating +
                '}';
    }

    @Override
    public boolean isKidFriendly() {
        if (genre.equals(movieGenre.HORROR) || genre.equals(movieGenre.THRILLERS)){
            return false;
        }
        return true;
    }

    //@Override
    /*public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Weblink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>").append(url).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");
        return builder.toString();
    }*/
}
