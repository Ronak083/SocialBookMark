package test;

import Constants.movieGenre;
import Entity.Movie;
import manager.bookMarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void isKidFriendly() {
        //test 1
        Movie movie = bookMarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles,Joseph Cotten"}, new String[]{"Orson Welles"}, movieGenre.HORROR, 8.5);
        boolean isKidFriendly = movie.isKidFriendly();
        assertFalse(isKidFriendly, "for Horror Genre - IsKidFriendly must be false");

        //test 1
         movie = bookMarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles,Joseph Cotten"}, new String[]{"Orson Welles"}, movieGenre.CLASSICS, 8.5);
         isKidFriendly = movie.isKidFriendly();
        assertFalse(isKidFriendly, "for Horror Genre - IsKidFriendly must be false");

        //test 1
         movie = bookMarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles,Joseph Cotten"}, new String[]{"Orson Welles"}, movieGenre.CLASSICS, 8.5);
         isKidFriendly = movie.isKidFriendly();
        assertFalse(isKidFriendly, "for Horror Genre - IsKidFriendly must be false");
    }
}