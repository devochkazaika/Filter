package com.filter.Statistic;

import com.filter.Statistic.Types.*;

public class Statistic {
    static StatisticInt integers = new StatisticInt();
    static StatisticString strings = new StatisticString();
    static StatisticFloat floats = new StatisticFloat();

    private static <T> Object getValue(IStatisticTypes<T> type, String fieldName) {
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

    protected <T> void setValue(IStatisticTypes<T> type, String arg, T value) {
        switch (arg) {
            case "count":
                type.setCount((int) value);
                break;
            case "sum":
                type.setSum(value);
                break;
            case "min":
                type.setMin(value);
                break;
            case "max":
                type.setMax(value);
                break;
        }
    }

    private static <T extends Comparable<T>> void Add(T value, IStatisticTypes<T> stat) {
        stat.setCount(stat.getCount() + 1);
        T currentMax = stat.getMax();
        T currentMin = stat.getMin();

        if (currentMax == null || value.compareTo(currentMax) > 0) {
            stat.setMax(value);
        }

        if (currentMin == null || value.compareTo(currentMin) < 0) {
            stat.setMin(value);
        }

        stat.setSum(value);
        stat.setMean(stat.getSum(), stat.getCount());
    }

    public static void AddFloat(String text){
        Add(Float.parseFloat(text), floats);
    }
    public static void AddInt(String text){
        Add(Integer.parseInt(text), integers);
    }
    public static void AddString(String text){
        Add(text.length(), strings);
    }

    static String[] name_rows = {"count", "mean", "sum", "min", "max"};
    public static <T> int get(IStatisticTypes<T> type, boolean t){
        String tmp;
        tmp = ""+type.getCount();
        System.out.println("count" + " ".repeat(10-name_rows[0].length()) + tmp);
        if (!t){
            return type.getCount();
        }
        if (type.getCount() != 0){
            int begin = (type instanceof StatisticString) ? 2 : 1;
            for (int i=begin; i<name_rows.length; i++) {
                tmp = getValue(type, name_rows[i]) + "";
                System.out.println(name_rows[i] + " ".repeat(10-name_rows[i].length()) + tmp);
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
