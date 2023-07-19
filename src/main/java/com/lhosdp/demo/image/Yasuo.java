package com.lhosdp.demo.image;

import cn.hutool.core.io.file.FileReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Yasuo {
    public static void main(String[] args) throws IOException {

        List<String> files = getFiles("D://before-image");
        int i = 100;
        for (String file : files) {
            System.out.println(file);
            FileReader fileReader = new FileReader(file);
            byte[] bytes = fileReader.readBytes();
            byte[] outputbytes = ImgUtils.compressPicByQuality(bytes, 0.5f);
            //FileWriter writer = new FileWriter("HCYS4659result.jpg");

            IOTest10.byteArrayToFile(outputbytes, "D://result-image//"+ i +".jpg");
            i++;
            String str = "{\"content\":\"0002\",\"imageUrl\":\"https://dev.lbapp.cn/fastdfs/groupfinmallpro/M00/00/00/t4YBAGI5lomAAAdiAAAPt3ltXLc072.png\",\"pageUrl\":\"https://small.lbapp.cn/#/spree/receive/138IA5L90GEK/6\"}";
        }



    }


    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }
}
