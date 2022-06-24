package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //Создание текста истории:
        StringBuilder sb = new StringBuilder();

        File dirGame = new File("D://GAME_JAVA");
        makeDirectory(dirGame);

        //Создание каталогов:
        File dirSrc = new File("D://GAME_JAVA//src");
        toLog(makeDirectory(dirSrc), sb);

        File dirRes = new File("D://GAME_JAVA//res");
        toLog(makeDirectory(dirRes), sb);

        File dirSaveGames = new File("D://GAME_JAVA//savegames");
        toLog(makeDirectory(dirSaveGames), sb);

        File dirTmp = new File("D://GAME_JAVA//temp");
        toLog(makeDirectory(dirTmp), sb);

        //Создание подкаталогов в src:
        File dirMain = new File("D://GAME_JAVA//src//main");
        toLog(makeDirectory(dirMain), sb);

        File dirTest = new File("D://GAME_JAVA//src//test");
        toLog(makeDirectory(dirTest), sb);

        //Создание подкаталогов в res:
        File dirResDraw = new File("D://GAME_JAVA//res//drawables");
        toLog(makeDirectory(dirResDraw), sb);

        File dirResVect = new File("D://GAME_JAVA//res//vectors");
        toLog(makeDirectory(dirResVect), sb);

        File dirResIcon = new File("D://GAME_JAVA//res//icons");
        toLog(makeDirectory(dirResIcon), sb);

        //Создание файлов! в main:
        File fileMain = new File(dirMain, "Main.java");
        toLog(makeFile(fileMain), sb);

        File fileUtil = new File(dirMain, "Utils.java");
        toLog(makeFile(fileUtil), sb);

        //Создание файла в temp:
        File fileTmp = new File(dirTmp, "temp.txt");
        toLog(makeFile(fileTmp), sb);

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
