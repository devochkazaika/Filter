package com.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileProcessing{
    //Файлы на чтение и запись
    private FileInputStream read;
    private FileOutputStream w;

    //Списки для разных типов данных
    private List<String> words;
    private List<String> floats;
    private List<String> integers;

    //Распределение разных типов
    public void getWords(List<String> words, String name){
        switch (name) {
            case "float":
                WriteTo("files/file2.txt");
                break;

            case "int":
                break;

            case "str":
                break;

            default:
                WriteTo("files/file2.txt");
                for (Object string : words) {
                    System.out.println(string);
                }
        }
    }

    //Буквы из которых состоят цифры
    Set<Character> NumericLetters = new HashSet<Character>(){{
        for (int i=0; i<10; i++) add((char) i);
        add('-');
        add('.');
        add(',');
        add('E');
        add('e');}
    };

    public FileProcessing(String path){
        words = new ArrayList<String>();
        floats = new ArrayList<String>();
        integers = new ArrayList<String>();

        try(FileInputStream a=new FileInputStream(path))
        {
            read = a;
            int i;
            char letter;
            String k = "";
            while((i=read.read())!=-1){
                letter = (char) i;
                if (i == (int)'\n'){
                    k = new String();
                }
                else{
                    if (NumericLetters.contains((char)'i')){
                        k+=(char)i;
                        words.add(k);
                    }
                    else{
                        k+=(char)i;
                    }
                }
            }   
            getWords(words, "s");
        }

        catch(IOException ex){
            System.out.println("AAAA");
            System.out.println(ex.getMessage());
        } 
    }
    public void WriteTo(String path){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), "utf-8"));
            writer.write("Something");
        } catch (IOException ex) {
            // Report
        } finally {
        try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
            }
}
