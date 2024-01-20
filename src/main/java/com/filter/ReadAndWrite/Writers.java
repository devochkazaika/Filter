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

    FileWriter integers;
    FileWriter floats;
    FileWriter strings;

    public Writers(String path) throws IOException{
    }

    public static HashMap<Integer, String> NameType = new HashMap<Integer, String>(){{
        put(0, "integers");
        put(1, "floats");
        put(2, "strings");
    }};

    public Writers(List<List<String>> Data, String path, String TextBefore, int FlagA) throws IOException{
        FileWriter file;
        boolean addFlag = (FlagA == 0) ? false : true;
        path = (path == null) ? "" : path;
        TextBefore = (TextBefore == null) ? "" : TextBefore;

        //Прохождение по всем типам данных в соответствии с индекс - ключ NameType, название - значение NameType[i]
        for (int i=0; i<3; i++){
            if (Data.get(i).size() != 0){
                File directory = new File(path);
                //создание папки, если ее нет
                if (!directory.exists()) {
                    directory.mkdirs();
                    new File(path + '/').mkdirs();
                }
                //запись
                try {
                    file = new FileWriter(path + '/' + TextBefore + NameType.get(i) + ".txt", StandardCharsets.UTF_8, addFlag);
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
