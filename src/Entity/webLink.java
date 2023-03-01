package Entity;
import org.junit.platform.commons.util.StringUtils;
import partner.Shareable;
public class webLink extends Bookmark implements Shareable {
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

    public String getHtmlPage() {
        return htmlPage;
    }

    public void setHtmlPage(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public void setHost(String host) {
        this.host = host;
    }
    private String url;
    private String host;
    private String htmlPage;
    private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;

    public enum DownloadStatus{
        NOT_ATTEMPTED,
        SUCCESS,
        FAILED,
        NOT_ELIGIBLE;
    }
    public boolean isKidFriendly(){
        if(url.contains("porn") || getTitle().contains("porn") ||host.contains("adult")){
            return false;
        }
        return true;
    }
    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Weblink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>").append(url).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");
        return builder.toString();
    }
}
