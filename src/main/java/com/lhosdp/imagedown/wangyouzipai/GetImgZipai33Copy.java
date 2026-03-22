package com.lhosdp.imagedown.wangyouzipai;


import cn.hutool.core.date.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * 爬取网站上图片--网友自拍
 * 列表页
 *  https://cxlye0.ydwlp.cn/2048/thread.php?fid=23&page=2
 * 详情页面
 * https://cxlye0.ydwlp.cn/2048/read.php?tid=15228967
 * 图片地址
 * https://post.imgso.net/images/2024/07/24/0719310vbiipitplp92b1y.jpg.thumb.jpg
 *
 */
public class GetImgZipai33Copy {

    public static void main(String[] args) {

            String htmlResource = getHtmlResourceByUrl();
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


//    下载图片到指定目录
//    private static void downloadImage(String imageUrl, Path saveDirectory) {
//        try {
//            URL url = new URL(imageUrl);
//            BufferedInputStream in = new BufferedInputStream(url.openStream());
//            byte[] dataBuffer = new byte[1024];
//            int bytesRead;
//            String imageName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
//
//            Path savePath = saveDirectory.resolve(imageName);
//
//            try (FileOutputStream fileOutputStream = new FileOutputStream(savePath.toFile())) {
//                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//                    fileOutputStream.write(dataBuffer, 0, bytesRead);
//                }
//            }
//
//            System.out.println("Image downloaded: " + imageUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void downloadImage(String imageUrl, Path savePath) {
        try (InputStream in = new URL(imageUrl).openStream()) {
//            Path saveFilePath = Paths.get(savePath);

            Files.copy(in, savePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("图片下载成功，保存路径: " + savePath);
        } catch (IOException e) {
            System.err.println("下载图片时发生错误: " + e.getMessage());
        }
    }

    /**
     * 根据网页和编码获取网页内容和源代码

     */
    public static String getHtmlResourceByUrl(){
        String filePath = "D:\\work\\htmlsave\\response.html";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String htmlContent = contentBuilder.toString();
        return htmlContent;
    }






}
