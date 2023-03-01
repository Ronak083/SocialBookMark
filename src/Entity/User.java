package Entity;

import Constants.Gender;
import Constants.UserType;

public class User {
    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", usertype='" + usertype + '\'' +
                ", gender=" + gender +
                '}';
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public UserType getusertype() {
        return usertype;
    }
    public void setusertype(UserType usertype) {
        this.usertype = usertype;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private UserType usertype;
    private Gender gender;

}