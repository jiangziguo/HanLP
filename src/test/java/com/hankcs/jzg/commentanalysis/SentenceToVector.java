package com.hankcs.jzg.commentanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2018/2/23.
 */
public class SentenceToVector {
    public static void main(String[] args) {

        System.out.println(getMaxSentence("E:\\场景\\traindata\\allword.txt"));
    }

    public static int getMaxSentence(String file){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Set<Integer> rank = new HashSet<Integer>();
            String temp;
            int maxSentenceLength = 0;
            String maxSentence = null;

            while ((temp = bufferedReader.readLine()) != null){
                int sentenceLength = temp.split(" ").length;
                rank.add(sentenceLength);
                if (maxSentenceLength > sentenceLength){
                    continue;
                }
                maxSentence = temp;
                maxSentenceLength = sentenceLength;
            }
//            Collections.sort(rank);
            System.out.println(rank);
            System.out.println(maxSentence);
            return maxSentenceLength;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Map<String, List<String>> makeWord2VecToMap(String path) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Map<String, List<String>> vecMap = new HashMap<String, List<String>>();
        String temp;
        while ((temp = bufferedReader.readLine()) != null){
            List<String> sentence = Arrays.asList(temp.split(" "));
            if (sentence.size() < 3){
                continue;
            }
            String word = sentence.get(0);
            sentence.remove(0);
            vecMap.put(word, sentence);
        }
        return vecMap;
    }

    public static void makeSentence2Vec(String path, Map<String, List<String>> vecMap) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Map<String, String[]> vecMap = new HashMap<String, String[]>();
        String temp;
        while ((temp = bufferedReader.readLine()) != null){
            String[] vector = new String[3000];
            String[] sentence = temp.split(" ");
            for (int i = 0; i < vector.length; i++){
                if (i - 1 > sentence.length){
                    vector[i] = "0";
                }
                vector[i] = sentence[i + 1];
            }
        }
    }
}
