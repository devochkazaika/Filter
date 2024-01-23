package com.filter;

import java.io.IOException;
import com.filter.ReadAndWrite.Writers;
import com.filter.Statistic.Statistic;
 
 
public class App 
{
    //Статистика
    private static void describe(){
        if (StartParametrs.Parametrs.get("-f") > 0) Statistic.describe(true);
        else if (StartParametrs.Parametrs.get("-s") > 0) Statistic.describe(false);
    }

    public static void main(String[] args) throws IOException
    {
        StartParametrs.setParametrs(args);

        //Добавление имен файлов
        Filter filter = new Filter();
        StartParametrs.addFiles(filter);

        //вывод статистики
        describe();

        Writers output = new Writers(filter.getData(),   StartParametrs.ParametrsWithArg.get("-o"), 
                                                        StartParametrs.ParametrsWithArg.get("-p"), 
                                                        StartParametrs.Parametrs.get("-a"));

    }
}
