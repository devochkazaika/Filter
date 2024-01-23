package com.filter.ReadAndWrite;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


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
        
        path = (path == null) ? "." : path;
        if (path.charAt(0) == '/' && path.length() > 1){
            path = path.substring(1);
        }
        else if (path.charAt(0) == '/' && path.length() == 1){
            System.out.println("Неправильное имя пути " + path);
            path = ".";
        }
        if (path.charAt(0) == '.' && path.length() > 1 && path.charAt(1) == '/'){
            path = path.substring(2);
        }

        TextBefore = (TextBefore == null) ? "" : TextBefore;
        //Прохождение по всем типам данных в соответствии с индекс - ключ NameType, название - значение NameType[i]
        for (int i=0; i<NameType.size(); i++){
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
                    for (String data : Data.get(i)) {
                        file.write(data);
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
