package manager;

import Entity.User;

public class userManager {
    private static userManager instance = new userManager();
    private userManager(){
    }
    public static userManager getInstance(){
        return instance;
    }
    public User createUser(long id, String email, String password, String fisrtname, String lastname,int gender,String usertype){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setFisrtname(fisrtname);
        user.setLastname(lastname);
        user.setGender(gender);
        user.setPassword(password);
        user.setusertype(usertype);
        return user;
    }

}
