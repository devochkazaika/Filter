package com.filter.ReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.IIOException;

public class Readers{

    List<String> Text;

    private String readline(FileReader value) throws IOException{
        char letter;
        int c;
        String text = "";
        while((c=value.read())!=-1){
            letter = (char) c;
            if (letter == '\r') continue;
            else if (letter == '\n') return text;
            else{
                text += letter;
            }
        }
        if (text != "") return text;
        return null;
    }

    public Readers(String path) throws IOException{
        this(new LinkedList<>(){{add(path);}});
    }

    public Readers(List<String> paths) throws IOException{
        LinkedList<FileReader> files = new LinkedList<>();
        for (String path : paths) {
            Path p = Paths.get(path);
            if (Files.exists(p)){
                files.add(new FileReader(path, StandardCharsets.UTF_8));
            }
            else{
                System.out.println("Файла - " + path + " не существует");
            }
        }
        addToText(files);
    }
    public void addToText(LinkedList<FileReader> files) throws IOException{
        String line;
        Text = new ArrayList<>();
        while (files.size() != 0){
            for (FileReader read : files) {
                if ((line = readline(read)) != null) {
                    Text.add(line);
                }
                else{
                    files.remove(read);
                }   
            }
        }
    }

    public List<String> getText(){
        return Text;
    }
}

