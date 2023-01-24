package test;
import Entity.webLink;
import manager.bookMarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class webLinkTest {
    @Test
    void isKidFriendly() {
        //test 1
        webLink  = bookMarkManager.getInstance().createLink(2000, "Taming porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "");
        boolean isKidFriendly = webLink.isKidFriendly();
        assertFalse("For Porn in title = isKidFriendly() must return false",isKidFriendly);
        //test 2
        //test 3
        //test 4
    }
}