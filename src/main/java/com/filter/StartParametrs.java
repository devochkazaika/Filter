package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.filter.ReadAndWrite.Readers;

public class StartParametrs {
    static HashMap<String, String> ParametrsWithArg = new HashMap<>(){{
        put("-p", null);
        put("-o", null);
    }};
    static HashMap<String, Integer> Parametrs = new HashMap<>(){{
        put("-s", 0);
        put("-f", 0);
        put("-a", 0);
    }};
    //имена файлов
    static ArrayList<String> nameFiles = new ArrayList<String>();

    //задание параметра и проверка на корректность для параметров БЕЗ АРГУМЕНТА
    static void checkParametrs(String arg){
        if (Parametrs.get(arg) == 1){
            System.out.println("более 1 раза введен один и тот же параметр" + arg);
        }
        else{
            Parametrs.put(arg, 1);
        }
    }
    //задание параметра и проверка на корректность для параметров С АРГУМЕНТОМ
    static int checkParametrs(String arg, String value){
        if (ParametrsWithArg.get(arg) != null){
            System.out.println("более 1 раза введен один и тот же параметр - '" + arg + "' взят последний параметр");
            return 0;
        }
        else{
            if (value.charAt(0) == '-'){
                if (value.equals(arg)){
                    System.out.println("аргумент продублирован" + arg);
                }
                else{
                    System.out.println("не введен аргумент для параметра" + arg);
                }
                return 0;
            }
            ParametrsWithArg.put(arg, value);
            return 1;
        }
    }
    //задание параметров
    static void setParametrs(String[] args){
        Set<String> parametrs = new HashSet<>(Parametrs.keySet()){{addAll(ParametrsWithArg.keySet());}};
        for (int i=0; i<args.length; i++){
                if (parametrs.contains(args[i])){
                    if (Parametrs.containsKey(args[i])){
                        checkParametrs(args[i]);
                    }
                    else if (ParametrsWithArg.containsKey(args[i])){
                        i=i+checkParametrs(args[i], args[i+1]);
                    }
                }
                else{
                    nameFiles.add(args[i]);
                }
            }
        if (nameFiles.size() == 0) System.out.println("Не введены имена файлов");
    }

    static void checkpath(){
        String ob = ParametrsWithArg.get("-o");
        if (ob != null){
            if (ob.charAt(0) != '/'){

            }
            else{
                if (ob.length() == 1){
                    System.out.println("Неправильное имя пути для сохранения");
                    ParametrsWithArg.put("-o", null);
                }
            
            }
        }
    }
    
    public static void addFiles(Filter filter) throws IOException{
        Readers t = new Readers(nameFiles);
        filter.add(t.getText());
    }
}
