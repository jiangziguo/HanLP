package com.hankcs.tagcomment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/2/22.
 */
public class TrainData {
    public static void main(String[] args) {
        String path = "E:\\场景\\场景评论tag";
        for (String filePath : getAllFiles(path)){
            writeDataToFile(filePath);
        }
    }

    public static List<String> getAllFiles(String dir){
        List<String> filePathList = new ArrayList<String>();
        for (File file : new File(dir).listFiles()){
            filePathList.add(file.getAbsolutePath());
        }
        return filePathList;
    }

    public static void writeDataToFile(String fileName) {
        PrintWriter printWriter = null;
        BufferedReader bufferedReader;
        String str;
        try {
            printWriter = new PrintWriter(new FileWriter(new File("E:\\场景\\traindata\\alldata.txt"), true));
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((str = bufferedReader.readLine()) != null){
                printWriter.println(str);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}
