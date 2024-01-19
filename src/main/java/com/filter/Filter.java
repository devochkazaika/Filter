package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.filter.Statistic.Statistic;


public class Filter {
    //Списки для разных типов данных
    private List<String> strings;
    private List<String> integers;
    private List<String> floats;

    private void ClearLists(){
        this.strings = new ArrayList<>();
        this.integers = new ArrayList<>();
        this.floats = new ArrayList<>();
    }

    public Filter(){
        ClearLists();
    }
    public Filter(List<String> Text){
        ClearLists();
        add(Text);
    }

    public void add(List<String> Text){
        for (String i : Text) {
            try {
                Integer.parseInt(i);
                integers.add(i);
                Statistic.AddInt(i);
            } 
            catch(NumberFormatException e) {
                try {
                    Float.parseFloat(i);
                    floats.add(i);
                    Statistic.AddFloat(i);
                } 
                catch(NumberFormatException t) {
                    try{
                        strings.add(i);
                    }
                    catch(NumberFormatException a){
                        System.out.println("Ошибка распознавания");
                    }
                    Statistic.AddString(i);
                }
            }
        }
    }

    public List<List<String>> getData(){
        return new ArrayList<List<String>>(){{
            add(integers);
            add(floats);
            add(strings);
        }};
    }
}
