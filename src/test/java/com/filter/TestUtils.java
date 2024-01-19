package com.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtils {

    public static void createTestFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean isFileExists(String filePath) {
        return new File(filePath).exists();
    }
}