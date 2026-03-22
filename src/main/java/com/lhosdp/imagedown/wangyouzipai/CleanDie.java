package com.lhosdp.demo.controller.wangyouzipai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CleanDie {
    public static void main(String[] args) {
    // 假设你要检查的文件夹路径
    String folderPath = "D:\\work\\wangyouzipai";

    Path path = Paths.get(folderPath);

        try {
        // 获取文件夹内所有文件及子文件夹
        List<Path> fileList = Files.list(path).collect(Collectors.toList());



            // 判断文件夹内的文件数量是否少于1个
        boolean isEmptyOrSingleFile = fileList.size() < 1;

        // 计算文件夹大小
        long folderSize = fileList.stream()
                .mapToLong(file -> {
                    try {
                        return Files.size(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        // 判断文件夹大小是否小于1KB
        boolean isSmallFolder = folderSize < 1024;

        if (isEmptyOrSingleFile || isSmallFolder) {
            // 删除文件夹
            Files.walk(path)
                    .sorted((a, b) -> b.compareTo(a))
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                            System.out.println("Deleted: " + p);
                        } catch (IOException e) {
                            System.err.println("Failed to delete: " + p);
                            e.printStackTrace();
                        }
                    });
            System.out.println("Folder deleted successfully.");
        } else {
            System.out.println("Folder is not empty or is larger than 1KB.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
