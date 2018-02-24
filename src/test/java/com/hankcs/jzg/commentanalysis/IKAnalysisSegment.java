package com.hankcs.jzg.commentanalysis;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/2/23.
 */
public class IKAnalysisSegment {

    public static void main(String[] args) {
        try {
            iKASegment("E:\\场景\\场景评论tag\\学校.txt", "E:\\场景\\场景评论分词\\学校.txt", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iKASegment(String sourceData, String desData, boolean stopwordDicFlag) throws Exception{
        File inputData = new File(sourceData);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputData));
        String temp;
        List<String> stopDic = getStopDic();
        List<String> tempData = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        while ((temp = bufferedReader.readLine()) != null){
            for (String tempStr : parser(temp, stopDic, stopwordDicFlag)){
                stringBuilder.append(tempStr);
                stringBuilder.append(" ");
            }
            tempData.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        writeDataToFile(tempData, desData);
    }

    public static List<String> getStopDic() throws IOException {
        List<String> dirty = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\stopword.dic")), "utf8"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            dirty.add(str);
        }
        return dirty;
    }

    public static void writeDataToFile(List<String> allData, String filePath){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File(filePath));
            for (String data : allData){
                printWriter.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (printWriter != null){
                printWriter.close();
            }
        }
    }

    public static List<String> parser(String comment, List<String> stopwordDic, boolean stopwordFlag) {
        List<String> retData = new ArrayList<String>();
        Reader input = new StringReader(comment);
        IKSegmenter iks = new IKSegmenter(input, true);
        Lexeme lexeme;
        try {
            while ((lexeme = iks.next()) != null) {
                String key = lexeme.getLexemeText().toString();
                if (stopwordFlag && (stopwordDic.contains(key) || key.length() == 1)) {
                    continue;
                }
                retData.add(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return retData;
        }
    }
}
