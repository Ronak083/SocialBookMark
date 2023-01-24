package Entity;

public class webLink extends Bookmark{
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "webLink {" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private String url;
    private String host;
    public Boolean isKidFriendly(){
        return true;
    }
}
