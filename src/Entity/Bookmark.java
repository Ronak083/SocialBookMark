package Entity;
public abstract class Bookmark {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public boolean isKidFriendly() {
        return false;
    }

    private long id;
    private String title;
    private String profileURL;

    public User getSharedby() {
        return Sharedby;
    }

    public void setSharedby(User sharedby) {
        Sharedby = sharedby;
    }

    private User Sharedby;

    public User getKidFriendlymarkBy() {
        return kidFriendlymarkBy;
    }

    public void setKidFriendlymarkBy(User kidFriendlymarkBy) {
        this.kidFriendlymarkBy = kidFriendlymarkBy;
    }

    private User kidFriendlymarkBy;



    public String getKidFriendlyStatus() {
        return KidFriendlyStatus;
    }

    public void setKidFriendlyStatus(String kidFriendlyStatus) {
        KidFriendlyStatus = kidFriendlyStatus;
    }

    private String KidFriendlyStatus = Constants.KidFriendlyStatus.UNKNOWN;
}
