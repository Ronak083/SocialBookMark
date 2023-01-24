package test;
import Entity.webLink;
import manager.bookMarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class webLinkTest {
    @Test
    public void isKidFriendly() {
        //test 1 Porn in url-- false
        webLink webLink = bookMarkManager.getInstance().createLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com", "");
        boolean isKidFriendly = webLink.isKidFriendly();
        assertFalse(isKidFriendly, "For Porn in url = isKidFriendly() must return false");

        //test 2 Porn in title -- false
        webLink = bookMarkManager.getInstance().createLink(2000, "Taming porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "");
         isKidFriendly = webLink.isKidFriendly();
        assertFalse(isKidFriendly, "For Porn in title = isKidFriendly() must return false");

        //test 3 adult in host -- false
        webLink = bookMarkManager.getInstance().createLink(2000, "Taming tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "adult");
         isKidFriendly = webLink.isKidFriendly();
        assertFalse(isKidFriendly, "For adult in host = isKidFriendly() must return false");

        //test 4 adult in url but not in part -- true
        webLink = bookMarkManager.getInstance().createLink(2000, "Taming porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com", "");
         isKidFriendly = webLink.isKidFriendly();
        assertTrue(isKidFriendly, "For adult in url but not in part = isKidFriendly() must return True");

        //test 5 adult in title only -- true
        webLink = bookMarkManager.getInstance().createLink(2000, "Taming adult, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "");
         isKidFriendly = webLink.isKidFriendly();
        assertTrue(isKidFriendly, "For adult in title only = isKidFriendly() must return True");
    }
}