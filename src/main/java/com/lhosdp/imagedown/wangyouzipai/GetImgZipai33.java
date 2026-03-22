package com.lhosdp.imagedown.wangyouzipai;


import cn.hutool.core.date.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.Files;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 爬取网站上图片
 * 列表页
 *  https://cxlye0.ydwlp.cn/2048/thread.php?fid=23&page=2
 * 详情页面
 * https://cxlye0.ydwlp.cn/2048/read.php?tid=15228967
 * 图片地址
 * https://post.imgso.net/images/2024/07/24/0719310vbiipitplp92b1y.jpg.thumb.jpg
 *
 */
public class GetImgZipai33 {

    public static void main(String[] args) throws Exception {
        // 添加信任所有证书的配置
        trustAllCertificates();
        List<String> tieList = getTieList("https://cxlye0.ydwlp.cn/thread.php?fid=23");

        for (String urldetail : tieList) {
            //        //要爬取的网页地址
            String url = urldetail;
            //编码方式
            String encoding = "UTF-8";

            String htmlResource = getHtmlResourceByUrl(url, encoding);
            // 解析网页源代码
            Document document = Jsoup.parse(htmlResource);
            // 获取所有图片的地址
            Elements elements = document.getElementsByTag("img");
            Elements title = document.getElementsByTag("title");
            String val = title.text();

            System.out.println("-------------------------开始下载！----------------------------" + val);
            //存储到本地的位置
            String datefile = DateUtil.today();
            String filePath = "d:/work/wangyouzipai/"+datefile+"/" + val.substring(0, val.indexOf(" "));

            for (Element element : elements) {
                String imgSrc = element.attr("src");

                String newimgSrc = imgSrc.replace("https://", "http://");
                System.out.println("替换后的图片地址：" + newimgSrc);
                try{
                    createDir(filePath);
                    Path saveDirectory = Paths.get(filePath); // 图片保存路径
                    downloadImage(newimgSrc, saveDirectory);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error downloading , next");
                }

            }
            System.out.println("-------------------------下载完毕！----------------------------");
        }
    }

    //创建目录
    private static void createDir(String filePath){
        //存储到本地的位置
        Path saveDirectory = Paths.get(filePath); // 图片保存路径
        try {
            Files.createDirectories(saveDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取帖子列表页面数据
    public static List<String> getTieList(String listurl){
        ArrayList<String> strings = new ArrayList<>();
        //要爬取的网页地址
        String url = listurl;
        //编码方式
        String encoding = "UTF-8";
        //存储到本地的位置
        String htmlResource = getHtmlResourceByUrl(url, encoding);
        // 解析网页源代码
        Document document = Jsoup.parse(htmlResource);
        // 获取所有图片的地址a
        Elements elements = document.getElementsByTag("a");
        System.out.println("-------------------------获取列表！----------------------------");

        for (Element element : elements) {
            String style = element.attr("style");
            // 判断imgSrc是否为空且是否以"http://"或是"https://"开头
            if(style.equals("font-size:1.0em;")){
                String href = element.attr("href");
//                https://cxlye0.ydwlp.cn/2048/read.php?tid=15228967
                strings.add("https://cxlye0.ydwlp.cn/2048/" + href);
            }
        }
        return strings;
    }

//    下载图片到指定目录
    private static void downloadImage(String imageUrl, Path saveDirectory) {
        try {
            URL url = new URL(imageUrl);
            BufferedInputStream in = new BufferedInputStream(url.openStream());
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            String imageName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);

            Path savePath = saveDirectory.resolve(imageName);

            try (FileOutputStream fileOutputStream = new FileOutputStream(savePath.toFile())) {
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            }

            System.out.println("Image downloaded: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据网页和编码获取网页内容和源代码
     * @param url
     * @param encoding
     */
    public static String getHtmlResourceByUrl(String url,String encoding){
        StringBuffer buffer   = new StringBuffer();
        URL urlObj            = null;
        URLConnection uc      = null;
        InputStreamReader in  = null;
        BufferedReader reader = null;

        try {
            // 建立网络连接
            urlObj = new URL(url);
            // 打开网络连接
            uc     = urlObj.openConnection();
            uc.setRequestProperty("Accept", "*/*");
            uc.setRequestProperty("User-Agent", "PostmanRuntime/7.32.3");
//            uc.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//            uc.setRequestProperty("Connection", "keep-alive");
            // 创建输入流
            in     = new InputStreamReader(uc.getInputStream(),encoding);
            // 创建一个缓冲写入流
            reader = new BufferedReader(in);

            String line = null;
            while ((line = reader.readLine()) != null) {
                // 一行一行追加
                buffer.append(line+"\r\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }


    private static void trustAllCertificates() throws Exception {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }



}
