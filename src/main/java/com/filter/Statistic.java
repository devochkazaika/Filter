package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Statistic {
    public static class Single{
        int count = 0;
    }
    public interface InnerStatistic {
        public int getCount();
        public Object getMax();
        public Object getMin();
        public Object getSum();
        public float getMean();
        public void setValue(String arg, Object value);
    }
    public static class StatisticInt extends Single implements InnerStatistic{
        int sum = 0;
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        float mean = 0;
        @Override
        public int getCount(){return count;}
        @Override
        public Object getSum(){return sum;}
        @Override
        public Object getMax(){return max;}
        @Override
        public Object getMin(){return min;}
        @Override
        public float getMean() {return mean;}
        @Override
        public void setValue(String arg, Object value) {
            switch (arg) {
                case "count":
                    count = (int) value;
                    break;
                case "sum":
                    sum = (int) value;
                    break;
                case "min":
                    min = (int) value;
                    break;
                case "max":
                    max = (int) value;
                    break;
                case "mean":
                    mean = (float) value;
                    break;
            }
        }
    }
    public static class StatisticFloat extends Single implements InnerStatistic{
        float sum = 0;
        float max = -Float.MAX_VALUE;
        float min = Float.MAX_VALUE;
        float mean = 0;
        @Override
        public int getCount(){return count;}
        @Override
        public Object getSum(){return sum;}
        @Override
        public Object getMax(){return max;}
        @Override
        public Object getMin(){return min;}
        @Override
        public float getMean() {return mean;}
        @Override
        public void setValue(String arg, Object value) {
            switch (arg) {
                case "count":
                    count = (int) value;
                    break;
                case "sum":
                    sum = (float) value;
                    break;
                case "min":
                    min = (float) value;
                    break;
                case "max":
                    max = (float) value;
                    break;
                case "mean":
                    mean = (float) value;
                    break;
            }
        }
    }
    public static class StatisticString extends StatisticInt{}

    private static Object getValue(InnerStatistic type, String fieldName) {
        switch (fieldName) {
            case "count":
                return type.getCount();
            case "min":
                return type.getMin();
            case "max":
                return type.getMax();
            case "sum":
                return type.getSum();
            case "mean":
                return type.getMean();
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
    }

    static StatisticInt integers = new StatisticInt();
    static StatisticString strings = new StatisticString();
    static StatisticFloat floats = new StatisticFloat();


    private static void Add(int text, InnerStatistic tmp){
        tmp.setValue("count", tmp.getCount()+1);
        int value = text;
        if ((int) tmp.getMax() < value) tmp.setValue("max", value);
        if ((int) tmp.getMin() > value) tmp.setValue("min", value);
        tmp.setValue("sum", (int)tmp.getSum()+value);
        float sum = (int) tmp.getSum();
        float count = (int) tmp.getCount();
        tmp.setValue("mean", sum/count);
    }
    private static void Add(float text, InnerStatistic tmp){
        float value = text;
        tmp.setValue("count", tmp.getCount()+1);
        if ((float) tmp.getMax() < value) tmp.setValue("max", value);
        if ((float) tmp.getMin() > value) tmp.setValue("min", value);
        tmp.setValue("sum", (float)tmp.getSum()+value);
        tmp.setValue("mean", (float) tmp.getSum() / (float) tmp.getCount());
    }
    private static void Add(String text, InnerStatistic tmp){
        int value = text.length();
        tmp.setValue("count", tmp.getCount()+1);
        if ((int) tmp.getMax() < value) tmp.setValue("max", value);
        if ((int) tmp.getMin() > value) tmp.setValue("min", value);
        tmp.setValue("sum", (int)tmp.getSum()+value);
    }
    protected static void AddFloat(String text){
        Add(Float.parseFloat(text), floats);
    }
    protected static void AddInt(String text){
        Add(Integer.parseInt(text), integers);
    }
    protected static void AddString(String text){
        Add(text, strings);
    }
    static String[] name_rows = {"count", "mean", "sum", "min", "max"};

    public static int get(InnerStatistic type, boolean t){
        String tmp;
        tmp = ""+type.getCount();

        System.out.println("count" + " ".repeat(10-name_rows[0].length()) + tmp);
        if (!t){
            return type.getCount();
        }
        if (type.getCount() != 0){
            if (type instanceof StatisticString){
                for (int i=3; i<name_rows.length; i++) {
                    tmp = Integer.toString((int) getValue(type, name_rows[i]));
                    System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
                }
            }
            else if (type instanceof StatisticInt) {
                for (int i=2; i<name_rows.length; i++) {
                    tmp = Integer.toString((int) getValue(type, name_rows[i]));
                    System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
                }
                System.out.println("mean" + " ".repeat(10-name_rows[1].length()) + getValue(type, "mean"));
                
            }
            else if (type instanceof StatisticFloat){
                for (int i=2; i<name_rows.length; i++) {
                    tmp = Float.toString((float) getValue(type, name_rows[i]));
                    System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
                }
                System.out.println("mean" + " ".repeat(10-name_rows[1].length()) + getValue(type, "mean"));
            }
        }
        return type.getCount();
    }
    protected static void getIntegers(boolean t){
        get(integers, t);
        System.out.println("dtype: int" + '\n');
    }

    protected static void getFloats(boolean t){
        get(floats, t);
        System.out.println("dtype: float" + '\n');
    }

    protected static void getStrings(boolean t){
        get(strings, t);
        System.out.println("dtype: string" + '\n');
    }
    // Статистика по всем типам данных с флагом "-s" - краткая, "-f" - полная
    public static void describe(boolean t){
        getIntegers(t);
        getFloats(t);
        getStrings(t);
    }
}
