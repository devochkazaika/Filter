package com.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistic {

    public class Single{
        float count = 0;
        float min = Integer.MAX_VALUE;
        float max = Integer.MIN_VALUE;
        float sum = 0;
        float mean;
        public Single(){};
        public Single(boolean t){
            min = Float.MAX_VALUE;
            max = Float.MIN_VALUE;
        }
    }
    static Single integers = Single();
    static float countInt = 0;
    static float minInt = Integer.MAX_VALUE;
    static float maxInt = Integer.MIN_VALUE;
    static float sumInt = 0;
    static float meanInt;

    static float countFloat = 0;
    static float minFloat = Float.MAX_VALUE;
    static float maxFloat = Float.MIN_VALUE;
    static float sumFloat = 0;
    static float meanFloat = 0;

    static float countString = 0;
    static float minString = Integer.MAX_VALUE;
    static float maxString = Integer.MIN_VALUE;
    static float sumString = 0;
    static float meanString = 0;

    protected static void AddFloat(String text){
        float elem = Float.parseFloat(text);
        if (minFloat > elem) minFloat = elem;
        if (maxFloat < elem) maxFloat = elem;
        sumFloat += elem;
        countFloat += 1;
        meanFloat += sumFloat / countFloat;
    }
    protected static void AddString(String text){
        float elem = Float.parseFloat(text);
        if (minFloat > elem) minFloat = elem;
        if (maxFloat < elem) maxFloat = elem;
        sumFloat += elem;
        countFloat += 1;
        meanFloat += sumFloat / countFloat;
    }
    protected static void AddInt(String text){
        int elem = Integer.parseInt(text);
        if (minInt > elem) minInt = elem;
        if (maxInt < elem) maxInt = elem;
        sumInt += elem;
        countInt += 1;
        meanInt += sumInt / countInt;
    }

    // List<String> name_rows = new ArrayList<>(Arrays.asList("count", "min", "max", "sum", "mean"));
    static String[] name_rows = {"count", "min", "max", "sum", "mean"};
    public static void describe(){
        for (String name : name_rows) {
            System.out.println(name_rows + " ".repeat(10-name_rows.length) + )
        }
    }
}
