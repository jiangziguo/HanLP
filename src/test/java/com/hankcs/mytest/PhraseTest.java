package com.hankcs.mytest;

import com.hankcs.hanlp.HanLP;

import java.util.List;

/**
 * Created by lenovo on 2018/2/7.
 */
public class PhraseTest {
    public static void main(String[] args) {
        List<String> phraseList = HanLP.extractPhrase("前女友就说我像小孩一样，到现在都不知道为什么，我要是不喜欢你，我比你爸都成熟", 5);
        System.out.println(phraseList);
    }
}
