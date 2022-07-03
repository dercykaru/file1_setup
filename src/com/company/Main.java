package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //Создание текста истории:
        StringBuilder sb = new StringBuilder();

        //Создание списка структуры каталогов.
        String katalogs[] = {
                "D://GAME_JAVA",
                "D://GAME_JAVA//src",
                "D://GAME_JAVA//res",
                "D://GAME_JAVA//savegames",
                "D://GAME_JAVA//temp",
                "D://GAME_JAVA//src//main",
                "D://GAME_JAVA//src//test",
                "D://GAME_JAVA//res//drawables",
                "D://GAME_JAVA//res//vectors",
                "D://GAME_JAVA//res//icons"
        };
        //Создание каталогов по указанному списку:
        for (String dir : katalogs) {
            File dirNext = new File(dir);
            toLog(makeDirectory(dirNext), sb);
        }

        //Создание списка файлов:
        String files2Create[] = {
                "D://GAME_JAVA//src//main//Main.java",
                "D://GAME_JAVA//src//main//Utils.java",
                "D://GAME_JAVA//temp//temp.txt"
        };
        //Создание файлов!
        for (String files : files2Create) {
            File fileNext = new File(files);
            toLog(makeFile(fileNext), sb);
        }

        //Вывод истории на экран:
        System.out.println(sb.toString());

        //Запись файла с историей:
        try (FileWriter writeFileTmp = new FileWriter("D://GAME_JAVA//temp//temp.txt", false)) {
            writeFileTmp.write(sb.toString());
            writeFileTmp.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    } //endofmain

    //Функция сбора отчетов для истории:
    public static StringBuilder toLog(String note, StringBuilder log) {
        log.append(note);
        log.append("\n");
        return log;
    }

    //Функция создания каталогов:
    public static String makeDirectory(File dir) {
        if (dir.mkdir()) {
            return String.format("Каталог %s успешно создан!", dir);
        } else if (dir.exists()) {
            return String.format("Каталог %s уже существует!", dir);
        } else {
            return String.format("Ошибка при создании каталога %s", dir);
        }
    }

    //Функция создания файлов:
    public static String makeFile(File file) {
        try {
            if (file.createNewFile()) {
                return String.format("Файл %s успешно создан!", file);
            } else if (file.exists()) {
                return String.format("Файл %s уже существует!", file);
            } else {
                return String.format("Файл %s не может быть создан!", file);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
