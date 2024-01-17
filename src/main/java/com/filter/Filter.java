package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Filter {

    public static Set<String> NumericLetters = new HashSet<String>(){{
        for (int i=0; i<10; i++) add(Integer.toString(i));
        add("-");
        add("+");
        add(".");
        add(",");
        add("E");
        add("e");
    }
    };
    public class Pair{
        public int key;
        public String value;
        public Pair(int k, String v){key =k; value =v;}
        public Pair(String v) {this(1, v);}
    }

    //Списки для разных типов данных
    private List<String> strings;
    private List<String> integers;
    private List<String> floats;

    private void ClearLists(){
        this.strings = new ArrayList<>();
        this.integers = new ArrayList<>();
        this.floats = new ArrayList<>();
    }

    public List<List<String>> getData(){
        return new ArrayList<List<String>>(){{
            add(integers);
            add(floats);
            add(strings);
        }};
    }

    public Filter(List<String> Text) throws IOException{
        ClearLists();
        Pair text;
        char letter;
        boolean forE = false;
        boolean forPoint = false;
        for (String string : Text) {
            text = new Pair(string);
            forE = false;
            forPoint = false;
            if (text.value == "") continue;
            for (int i=0; i<text.value.length(); i++){
                if (!NumericLetters.contains(Character.toString(text.value.charAt(i)))){
                    text.key = 3;
                }
                else{
                    letter = text.value.charAt(i);
                    if (letter == '-' || letter == '+'){
                        //Если '+' стоит первым или '-' или '+' стоит последним тогда записать в string
                        if (letter == '+' && (i == 0 || i == text.value.length()-1)){
                            text.key = 3;
                        }
                        else{
                            //Если '-' первый или после него идет НЕ цифра записать в string то есть для E+14 E-12 и тд
                            if (i != 0 && (text.value.charAt(i+1) < '0' || text.value.charAt(i+1) > '9')){
                                text.key = 3;
                            }
                        }
                    }
                    else if (letter == 'E'){
                        //Если E НЕ последний и после него НЕ идет '-' или '+' записать в string
                        if (i == text.value.length()-1 || (text.value.charAt(i+1) != '-' && text.value.charAt(i+1) != '+') || forE){
                            text.key = 3;
                        }
                        forE = true;
                    }
                    else if (letter == '.'){
                        //Если точка первая или последняя или не принадлежит (0, ..., 9)
                        if (i == 0 || i == text.value.length() - 1
                        || (text.value.charAt(i-1) > '9' || text.value.charAt(i-1) < '0')
                        || (text.value.charAt(i+1) > '9' || text.value.charAt(i+1) < '0') 
                        || forPoint){
                            text.key = 3;
                        }
                        else if (text.key < 2) text.key = 2;

                        forPoint = true;
                    }
                }
            }
            switch (text.key){
                case 1:
                    System.out.println(text.value + "=" + "int");
                    integers.add(text.value);
                    Statistic.AddInt(text.value);
                    break;
                case 2:
                    System.out.println(text.value + "=" +"float");
                    floats.add(text.value);
                    Statistic.AddFloat(text.value);
                    break;
                case 3:
                    System.out.println(text.value + "=" +"str");
                    strings.add(text.value);
                    Statistic.AddString(text.value);
                    break;
            }
            text = new Pair(new String());
        } 
    }
}
