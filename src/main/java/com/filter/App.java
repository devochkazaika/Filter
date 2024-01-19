package com.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.filter.Statistic.Statistic;
 
 
public class App 
{
    static HashMap<String, Integer> Parametrs = new HashMap<>(){{
        put("-s", 0);
        put("-f", 0);
        put("-a", 0);
    }};
    static HashMap<String, String> ParametrsWithArg = new HashMap<>(){{
        put("-p", null);
        put("-o", null);
    }};
    static Set<String> nameFiles = new HashSet<String>();

    static void checkParametrs(String arg){
        if (Parametrs.get(arg) == 1){
            System.out.println("более 1 раза введен один и тот же параметр" + arg);
        }
        else{
            Parametrs.put(arg, 1);
        }
    }
    static int checkParametrs(String arg, String value){
        if (ParametrsWithArg.get(arg) != null){
            System.out.println("более 1 раза введен один и тот же параметр -" + arg + " взят последний параметр");
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
    }

    public static void start() throws IOException{
        Filter k = new Filter();
        for (String string : nameFiles) {
            Readers t = new Readers(string);
            k.add(t.getText());
        }
    }

    public static void main(String[] args ) throws IOException
    {
        setParametrs(args);
        System.out.println(Parametrs);
        System.out.println(ParametrsWithArg);
        System.out.println(nameFiles);
        Filter k = new Filter();
        for (String string : nameFiles) {
            Readers t = new Readers(string);
            k.add(t.getText());
        }
        if (Parametrs.get("-s") > 0) Statistic.describe(false);
        else if (Parametrs.get("-f") > 0) Statistic.describe(true);
        Writers s = new Writers(k.getData(), ParametrsWithArg.get("-o"), 
                                            ParametrsWithArg.get("-p"), 
                                            Parametrs.get("-a"));

    }
}
