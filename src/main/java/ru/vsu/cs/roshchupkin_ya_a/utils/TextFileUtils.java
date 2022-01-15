package ru.vsu.cs.roshchupkin_ya_a.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileUtils {
    private static final File defaultFile = new File("src/main/resources/gameField.txt");

    public static String read() throws FileNotFoundException {
        Scanner sc = new Scanner(defaultFile);
        sc.useDelimiter("\\Z");
        return sc.next();
    }

    public static String read(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        sc.useDelimiter("\\Z");
        return sc.next();
    }

    public static void write(String textToWrite) throws IOException {
        defaultFile.createNewFile();
        FileWriter outputWriter = new FileWriter(defaultFile);
        outputWriter.write(textToWrite);
        outputWriter.close();
    }

    public static void write(String filePath, String textToWrite) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        FileWriter outputWriter = new FileWriter(file);
        outputWriter.write(textToWrite);
        outputWriter.close();
    }
}
