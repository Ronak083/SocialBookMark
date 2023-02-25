package bgJobs;

import Entity.webLink;
import dao.bookmarkDao;
import util.HttpConnect;
import util.IOUtil;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WebPageDownloaderTask implements Runnable{
    private static bookmarkDao dao = new bookmarkDao();
    private static final long TIME_FRAME = 3000000000L;
    private boolean downloadAll = false;
    ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);
    private static class Downloader<T extends webLink> implements Callable<T>{
        private T weblink;
        public Downloader(T weblink){
            this.weblink = weblink;
        }
        @Override
        public T call(){
            try {
                if (!weblink.getUrl().endsWith(".pdf")) {
                    weblink.setDownloadStatus(webLink.DownloadStatus.FAILED);
                    String htmlPage = HttpConnect.download(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);
                } else{
                    weblink.setDownloadStatus(webLink.DownloadStatus.NOT_ELIGIBLE);
                }
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
            return weblink;
        }
    }
    public WebPageDownloaderTask(boolean downloadAll){
        this.downloadAll = downloadAll;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            List<webLink> webLinks = getWebLinks();

            if (webLinks.size() > 0){
                download(webLinks);
            } else {
                System.out.println("No, new web links to download!!");
            }

            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        downloadExecutor.shutdown();
    }
    private void download(List<webLink> webLinks) {
        List<Downloader<webLink>> tasks = getTasks(webLinks);
        List<Future<webLink>> futures = new ArrayList<>();

        try {
            futures = downloadExecutor.invokeAll(tasks, TIME_FRAME, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (Future<webLink> future : futures){
            try{
                if (!future.isCancelled()){
                    webLink webLink = future.get();
                    String webPage = webLink.getHtmlPage();
                    if (webPage != null){
                        IOUtil.write(webPage, webLink.getId());
                        webLink.setDownloadStatus(Entity.webLink.DownloadStatus.SUCCESS);
                        System.out.println("Download Success:   "+ webLink.getUrl());
                    } else {
                            System.out.println("Web page not downloaded : "+ webLink.getUrl());
                    }
                } else{
                    System.out.println("/n/nTasks is cancelled -->" + Thread.currentThread());
                }

            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private List<Downloader<webLink>> getTasks(List<webLink> webLinks) {
        List<Downloader<webLink>> tasks = new ArrayList<>();
        for (webLink webLink : webLinks){
            tasks.add(new Downloader<webLink>(webLink));
        }
        return tasks;
    }
    private List<webLink> getWebLinks() {
        List<webLink> webLinks = null;
        if (downloadAll){
            webLinks = dao.getAllWebLinks();
            downloadAll = false;
        } else {
            webLinks = dao.getWebLinks(webLink.DownloadStatus.NOT_ATTEMPTED);
        }
        return webLinks;
    }
}
