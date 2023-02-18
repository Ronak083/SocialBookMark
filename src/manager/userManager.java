package manager;

import Entity.User;
import dao.userDao;

public class userManager {
    private static userManager instance = new userManager();
    private static userDao dao = new userDao();
    public User[] getUsers(){
        return dao.getUser();
    }
    private userManager(){
    }
    public static userManager getInstance(){
        return instance;
    }
    public User createUser(long id, String email, String password, String firstname, String lastname, int gender, String usertype){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setGender(gender);
        user.setPassword(password);
        user.setusertype(usertype);
        return user;
    }

}
