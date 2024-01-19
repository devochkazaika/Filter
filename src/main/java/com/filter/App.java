package com.filter;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
 
 
public class App 
{
    static HashMap<String, String> Parametrs = new HashMap<>(){{
        put("-s", null);
        put("-f", null);
        put("-o", null);
        put("-a", null);
        put("-p", null);
    }};

    static void checkParametrs(String[] args){
        String value;
        for (int i=0; i<args.length; i++){
            value = Parametrs.get(args[i]);
            if (value.charAt(0) == '-' && value.charAt(1) == 'f' || value.charAt(1) == 's'){
                Parametrs.put(args[i], "1");
            }
            if (value.charAt(0) == '-'){
                Parametrs.put(args[i], args[i+1]);
                if (value != null){
                    System.out.println("2 раза введен один и тот же параметр" + args[i]);
                }
            }
            else{
                System.out.println("Значение" + args[i]+ "без параметра");
            }
        }
    }

    public static void main(String[] args ) throws IOException
    {
        checkParametrs(args);
        
        Readers t = new Readers("files/file2.txt");
        Filter k = new Filter(t.getText());
        Statistic.describe(true);
        Statistic.describe(false);
        // Writers s = new Writers(k.getData(), "int", "sd_");

    }
}
