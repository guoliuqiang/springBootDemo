package com.lhosdp.demo.poi;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPoi {
    private static Logger logger = Logger.getLogger(TestPoi.class.getName());
    public static void main(String[] args) {

        // 创建需要写入的数据列表
        List<StLbsCoupon> dataVOList = new ArrayList<>(2);
        new StLbsCoupon();
        // 写入数据到工作簿对象内
        Workbook workbook = ExcelWriter.exportData(dataVOList);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String property = System.getProperty("user.dir");
            System.out.println(property);
//            String path = ResourceUtils.getURL("classpath:").getPath();
//            System.out.println(path);
            String exportFilePath = property + "/writeExample.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warn("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.warn("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }
    }



    private void testhutuPoi(){

    }
}
