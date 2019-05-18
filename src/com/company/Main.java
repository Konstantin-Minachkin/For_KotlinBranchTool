package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    //Напишите консольную программу, которая найдет в заданной дирректории и во всех поддиректориях файлы с
    // расширениями java или kt и переименует их, добавив к полному имени ".2019"
    // (файл A.java должен быть переименован в A.java.2019).
    // Программа должна вывести полный список переименнованных файлов в консоль.

    public static File addExt (File file, String newExt) {
        int i = file.getName().lastIndexOf('.');
        if (file.getName().substring(i).matches(".(java|kt)")) {
            System.out.println(file.getName() + "\t - has changed in " + file.getParent());
            return new File(file.getParent() + "/" + file.getName() + newExt);
        }
        else return file.getAbsoluteFile();
    }

    private static void readFolder(String dir){
        File folder = new File(dir);
        if(folder.isDirectory())
        {
            for(File file : folder.listFiles()){
                if(file.isFile()){
                    file.renameTo(addExt(file, ".2019"));
                }
                else if (file.isDirectory()) readFolder(file.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a directory: ");
        readFolder(in.next());
    }
}
