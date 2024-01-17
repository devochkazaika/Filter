package com.filter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.IIOException;

public class Readers extends FileReader{

    List<String> Text;

    private String readline() throws IOException{
        char letter;
        int c;
        String text = "";
        while((c=this.read())!=-1){
            letter = (char) c;
            if (letter == '\r') continue;
            else if (letter == '\n') return text;
            else{
                text += letter;
            }
        }
        return null;
    }

    public Readers(String path) throws IOException{
        super(path, StandardCharsets.UTF_8);
        String line;
        Text = new ArrayList<>();
        while ((line = readline()) != null) {
            Text.add(line);
        }
    }

    public List<String> getText(){
        return Text;
    }
}

