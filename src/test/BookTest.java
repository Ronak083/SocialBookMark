package test;

import Constants.bookGenre;
import Entity.Book;
import manager.bookMarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void isKidFriendly() {
        //test 1
        Book bk = bookMarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, bookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendly = bk.isKidFriendly();
        assertFalse(isKidFriendly,"For philosophy Genre - isKidFriendly should be false");

        //test 2
        bk = bookMarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, bookGenre.SELFHELP, 4.3);
        isKidFriendly = bk.isKidFriendly();
        assertFalse(isKidFriendly,"For self help Genre - isKidFriendly should be false");
    }
}