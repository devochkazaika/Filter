package com.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    // @Test
    // public void testFilterFiles() {
    //     // Создаем тестовые файлы
    //     String inputFilePath1 = "test_input1.txt";
    //     String inputFilePath2 = "test_input2.txt";
    //     String outputPath = "output";

    //     TestUtils.createTestFile(inputFilePath1, "1\n2\n3\n");
    //     TestUtils.createTestFile(inputFilePath2, "4.5\n6.7\n8.9\n");
    //     String parametrs[] = {"-o", outputPath, inputFilePath1, inputFilePath2};
    //     // Тестируем утилиту
    //     try{
    //         App.main(parametrs);
    //     }
    //     catch(IOException e){
    //         System.out.println("Не работает(");
    //     }

    //     // Проверяем результаты
    //     assertTrue(TestUtils.isFileExists(outputPath + "integers.txt"));
    //     assertTrue(TestUtils.isFileExists(outputPath + "floats.txt"));
    //     assertFalse(TestUtils.isFileExists(outputPath + "strings.txt"));

    //     // Очищаем тестовые файлы
    //     TestUtils.deleteFile(inputFilePath1);
    //     TestUtils.deleteFile(inputFilePath2);
    //     TestUtils.deleteFile(outputPath + "integers.txt");
    //     TestUtils.deleteFile(outputPath + "floats.txt");
    // }

    // @Test
    // public void testFilterFilesWithPrefix() {
    //     // Создаем тестовые файлы
    //     String inputFilePath1 = "test_input1.txt";
    //     String inputFilePath2 = "test_input2.txt";
    //     String outputPath = "output";
    //     String prefix = "result_";

    //     TestUtils.createTestFile(inputFilePath1, "1\n2\n3\n");
    //     TestUtils.createTestFile(inputFilePath2, "4.5\n6.7\n8.9\n");

    //     // Тестируем утилиту
    //     String parametrs[] = {"-o", outputPath, "-p", prefix, inputFilePath1, inputFilePath2};
    //     try{
    //         App.main(parametrs);
    //     }
    //     catch(IOException e){
    //         System.out.println("Не работает(");
    //     }

    //     // Проверяем результаты
    //     assertTrue(TestUtils.isFileExists(outputPath + prefix + "integers.txt"));
    //     assertTrue(TestUtils.isFileExists(outputPath + prefix + "floats.txt"));
    //     assertFalse(TestUtils.isFileExists(outputPath + prefix + "strings.txt"));

    //     // Очищаем тестовые файлы
    //     TestUtils.deleteFile(inputFilePath1);
    //     TestUtils.deleteFile(inputFilePath2);
    //     TestUtils.deleteFile(outputPath + prefix + "integers.txt");
    //     TestUtils.deleteFile(outputPath + prefix + "floats.txt");
    // }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
