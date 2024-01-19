package com.filter.ReadAndWrite;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Writers{
    private List<String> words;

    FileWriter integers;
    FileWriter floats;
    FileWriter strings;

    public Writers(String path) throws IOException{
    }

    public static HashMap<Integer, String> IndexType = new HashMap<Integer, String>(){{
        put(0, "integers");
        put(1, "floats");
        put(2, "strings");
    }};

    public static void AddText(String filePath, String text){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println("Ошибка при добавлении текста в файл " + filePath);
        }
    }

    public Writers(List<List<String>> Data, String path, String TextBefore, int FlagA) throws IOException{
        FileWriter file;
        boolean addFlag = (FlagA == 0) ? false : true;
        path = (path == null) ? "" : path;
        TextBefore = (TextBefore == null) ? "" : TextBefore;

        for (int i=0; i<3; i++){
            if (Data.get(i).size() != 0){
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs();
                    new File(path + '/').mkdirs();
                }
                try {
                    file = new FileWriter(path + '/' + TextBefore + IndexType.get(i) + ".txt", StandardCharsets.UTF_8, addFlag);
                    for (String integer : Data.get(i)) {
                        file.write(integer);
                        file.append('\n');
                    }
                    file.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
