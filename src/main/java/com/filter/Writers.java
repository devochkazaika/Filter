package com.filter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Writers{
    private List<String> words;

    FileWriter integers;
    FileWriter floats;
    FileWriter strings;

    public Writers(String path) throws IOException{
    }

    HashMap<Integer, String> IndexType = new HashMap<Integer, String>(){{
        put(0, "integers");
        put(1, "floats");
        put(2, "strings");
    }};

    public Writers(List<List<String>> Data, String path, String TextBefore) throws IOException{
        FileWriter file;
        for (int i=0; i<3; i++){
            if (Data.get(i).size() != 0){
                file = new FileWriter(IndexType.get(i) + ".txt", StandardCharsets.UTF_8);
                for (String integer : Data.get(i)) {
                    file.write(integer);
                    file.append('\n');
                }
                file.close();
            }
        }

    }
}
