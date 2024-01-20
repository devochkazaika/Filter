package com.filter.ReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        FileReader read = new FileReader(path, StandardCharsets.UTF_8);
        String line;
        Text = new ArrayList<>();
        if ((line = readline(read)) != null) {
            Text.add(line);
        }
    }

    public Readers(Collection<String> paths) throws IOException{
        LinkedList<FileReader> Files = new LinkedList<>();
        for (String path : paths) {
            Files.add(new FileReader(path, StandardCharsets.UTF_8));
        }
        String line;
        Text = new ArrayList<>();
        while (Files.size() != 0){
            for (FileReader read : Files) {
                if ((line = readline(read)) != null) {
                    Text.add(line);
                }
                else{
                    Files.remove(read);
                }   
            }
        }
    }

    public List<String> getText(){
        return Text;
    }
}

