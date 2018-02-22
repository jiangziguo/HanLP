/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/12/10 22:02</create-date>
 *
 * <copyright file="DemoCRFSegment.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014, 上海林原信息科技有限公司. All Right Reserved, http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.demo;

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
 * CRF分词(在最新训练的未压缩100MB模型下，能够取得较好的效果，可以投入生产环境)
 *
 * @author hankcs
 */
public class DemoCRFSegment
{
    public static void main(String[] args) throws Exception
    {
        HanLP.Config.ShowTermNature = false;    // 关闭词性显示
        Segment segment = new CRFSegment().enableCustomDictionary(false);
        File inputData = new File("E:\\hanLP\\data\\allData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputData));
        String sentence;
        List<String> tempData = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
//        List<String> stopDic = getDirty();
        while ((sentence = bufferedReader.readLine()) != null){
            List<Term> termList = segment.seg(sentence);
            for (Term term : termList){
//                String word = term.word;
//                if (stopDic.contains(word)){
//                    continue;
//                }
                stringBuilder.append(term.word);
                stringBuilder.append(" ");
            }
            tempData.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        writeDataToFile(tempData);

        /**
         * 内存CookBook:
         * HanLP内部有智能的内存池，对于同一个CRF模型（模型文件路径作为id区分），只要它没被释放或者内存充足，就不会重新加载。
         */
        for (int i = 0; i < 5; ++i)
        {
            segment = new CRFSegment();
        }


    }

    public static List<String> getDirty() throws IOException {
        List<String> dirty = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\stopword.dic")), "utf8"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            dirty.add(str);
        }
        return dirty;
    }

    public static void writeDataToFile(List<String> allData){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("E:\\hanLP\\data\\crf.txt"));
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
}
