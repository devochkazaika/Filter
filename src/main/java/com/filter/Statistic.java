package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Statistic {

    public static class Single{
        public Single(){}
        public int count = 0;
        public final int min = Integer.MAX_VALUE;
        public final int max = Integer.MIN_VALUE;
        public final int sum = 0;
        public float mean = 0;
        
        public int get(String arg){
            switch (arg) {
                case "count":
                    return count;
                    break;
                case "min":
                    return min;
                    break;
                case "max":
                    return max;
                    break;
                case "sum":
                    return sum;
                    break;
            }
        }
    }
    public static class SingleFloat extends Single{
        public float min = Float.MAX_VALUE;
        public float max = Float.MIN_VALUE;
        public float sum = 0;
    }
    
    static Single integers = new Single();
    static Single floats = new Single();
    static Single strings = new Single();


    private static void Add(String text, Single tmp){
        float elem = Float.parseFloat(text);
        if (tmp.min > elem) tmp.min = elem;
        if (tmp.max < elem) tmp.set("max", elem);
        tmp.set("sum", tmp.get("sum")+elem);
        tmp.count++;
        tmp.set("mean", tmp.get("sum")/tmp.count);
    }

    protected static void AddFloat(String text){
        Add(text, floats);
    }
    protected static void AddInt(String text){
        Add(text, integers);
    }
    protected static void AddString(String text){
        Add(Integer.toString(text.length()), strings);
    }

    protected static void getIntegers(){
        Single type = integers;
        String tmp;
        tmp = ""+type.count;
        System.out.println("count" + " ".repeat(10-name_rows[0].length()) + tmp);
        if (type.count != 0){
            for (int i=1; i<name_rows.length; i++) {
                tmp = "" + type.get(name_rows[i]);
                System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
            }
        }
        System.out.println("dtype: int" + '\n');
    }

    protected static void getFloats(){
        Single type = floats;
        String tmp;
        tmp = ""+type.count;
        System.out.println("count" + " ".repeat(10-name_rows[0].length()) + tmp);
        if (type.count != 0){
            for (int i=1; i<name_rows.length; i++) {
                tmp = "" + type.get(name_rows[i]);
                System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
            }
        }
        System.out.println("dtype: float" + '\n');
    }

    protected static void getStrings(){
        Single type = strings;
        String tmp;
        tmp = ""+type.count;
        System.out.println("count" + " ".repeat(10-name_rows[0].length()) + tmp);
        if (type.count != 0){
            for (int i=1; i<name_rows.length; i++) {
                tmp = "" + type.get(name_rows[i]);
                System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
            }
        }
        System.out.println("dtype: string" + '\n');
    }
    // List<String> name_rows = new ArrayList<>(Arrays.asList("count", "min", "max", "sum", "mean"));
    static String[] name_rows = {"count", "min", "max", "sum", "mean"};
    public static void describe(){
        getIntegers();
        getFloats();
        getStrings();
    }
}
