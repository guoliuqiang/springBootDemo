package com.lhosdp.demo.controller.wangyouzipai;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DirectorySizeFetcherAndDeleter {

    public static void main(String[] args) {
        // 指定要检查的根目录路径
        String rootFolderPath = "D:\\work\\wangyouzipai";
        Path rootPath = Paths.get(rootFolderPath);

        try {
            // 使用Files.walk()方法递归地获取所有的子文件夹
            Map<Path, Long> sizes = Files.walk(rootPath)
                    .filter(Files::isDirectory)
                    .collect(Collectors.toMap(
                            path -> path,
                            DirectorySizeFetcherAndDeleter::getDirectorySize));

            // 按照文件夹层级排序，确保先处理子文件夹
            List<Path> sortedDirs = sizes.keySet().stream()
                    .sorted(Comparator.comparingLong(path -> -path.getNameCount()))
                    .collect(Collectors.toList());

            // 删除大小为0字节的文件夹
            for (Path dir : sortedDirs) {
                if (sizes.get(dir) == 0L) {
                    try {
                        Files.delete(dir);
                        System.out.printf("Deleted directory: %s%n", dir);
                    } catch (IOException e) {
                        System.err.printf("Failed to delete directory: %s%n", dir);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error walking the file tree: " + rootPath);
            e.printStackTrace();
        }
    }

    /**
     * 计算指定文件夹的大小。
     *
     * @param directory 文件夹路径
     * @return 文件夹的大小（字节）
     * @throws IOException 如果出现IO错误
     */
    private static long getDirectorySize(Path directory) {
        try {
            return Files.walk(directory)
                    .filter(path -> Files.isRegularFile(path))
                    .mapToLong(path -> {
                        try {
                            return Files.size(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
