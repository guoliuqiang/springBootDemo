package com.lhosdp.imagedown;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class GetImage {

    public static void main(String[] args) {
        GetImage getImage = new GetImage();
        getImage.downloadImagesFromUrl("https://cxlye0.ydwlp.cn/read.php?tid=18447497");
    }


    public void downloadImagesFromUrl(String url) {
        try {

            Document document = Jsoup.connect(url).get();
            String title = document.title();
            File directory = createDirectoryByTitle(title);

            Elements images = getImageUrlsFromHtml(document);
            for (Element image : images) {
                String imageUrl = image.absUrl("src");
                downloadImage(imageUrl, directory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File createDirectoryByTitle(String title) {
        File directory = new File("D:\\xingyuanDownload\\move\\small\\activity\\equity\\dongxi\\image\\" + title);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }

    private Elements getImageUrlsFromHtml(Document document) {
        return document.select("img[src]");
    }

    private void downloadImage(String imageUrl, File directory) {
        try {
            URL website = new URL(imageUrl);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(directory.getAbsolutePath() + "\\" + imageUrl.substring(imageUrl.lastIndexOf("/") + 1));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
