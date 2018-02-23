package com.hankcs.jzg.commentanalysis;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/2/8.
 */
public class CommentTag {
    public static final String FILE_NAME = "爱情.txt";

    public static void main(String[] args) throws Exception {
        File inputData = new File("E:\\场景\\原始数据\\origindata.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputData));
        String sentence;
        List<String> tempData = new ArrayList<String>();
        List<String> stopDic = getSceneKeyWord(FILE_NAME);
        while ((sentence = bufferedReader.readLine()) != null) {
            for (String keyWord : stopDic){
                if (sentence.contains(keyWord)){
                    tempData.add(sentence);
                    break;
                }
            }
        }
        writeDataToFile(tempData, FILE_NAME);
    }

    public static List<String> getSceneKeyWord(String fileName) throws IOException {
        List<String> sceneKeyWord = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File("E:\\场景\\场景关键词\\" + fileName)), "utf8"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            sceneKeyWord.add(str.split("\t")[0]);
        }
        return sceneKeyWord;
    }

    public static void writeDataToFile(List<String> allData, String fileName) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("E:\\场景\\场景评论\\" + fileName));
            for (String data : allData) {
                printWriter.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
