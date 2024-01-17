package com.filter;

import java.io.IOException;
import java.io.Reader;

/**
 * Hello world!
 *
 */

 
 
public class App 
{
    // public static void reader(){
    //     try {
    //         File file = new File("files/file.txt");
    //         //создаем объект FileReader для объекта File
    //         FileReader fr = new FileReader(file);
    //         //создаем BufferedReader с существующего FileReader для построчного считывания
    //         BufferedReader reader = new BufferedReader(fr);
    //         // считаем сначала первую строку
    //         String line = reader.readLine();
    //         while (line != null) {
    //             System.out.println(line);
    //             // считываем остальные строки в цикле
    //             line = reader.readLine();
    //         }
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    public static void main( String[] args ) throws IOException
    {
        Readers t = new Readers("files/file2.txt");
        Filter k = new Filter(t.getText());
        Writers s = new Writers(k.getData(), "int", "sd_");

    }
}
