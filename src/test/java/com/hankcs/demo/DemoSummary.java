/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/12/7 19:25</create-date>
 *
 * <copyright file="DemoChineseNameRecoginiton.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014+ 上海林原信息科技有限公司. All Right Reserved+ http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.demo;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.summary.TextRankSentence;

import java.util.List;

/**
 * 自动摘要
 * @author hankcs
 */
public class DemoSummary
{
    public static void main(String[] args)
    {
        String document = "说不想谈恋爱是假的，说不羡慕人家秀恩爱是假的，只是真没有一个认真的所以宁愿选择单身，也不想要随便谈感情，因为我不想当我遇见更好的人的时候已经把最好的自己用完。";
        List<String> sentenceList = HanLP.extractSummary(document, 3);
        System.out.println(sentenceList);
    }
}
