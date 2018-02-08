/*
 * <summary></summary>
 * <author>hankcs</author>
 * <email>me@hankcs.com</email>
 * <create-date>2015/11/13 18:36</create-date>
 *
 * <copyright file="DemoRewriteDocument.java">
 * Copyright (c) 2003-2015, hankcs. All Right Reserved, http://www.hankcs.com/
 * </copyright>
 */
package com.hankcs.demo;

import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;

/**
 * @author hankcs
 */
public class DemoRewriteText
{
    public static void main(String[] args)
    {
        String text = "前女友就说我像小孩一样，到现在都不知道为什么，我要是不喜欢你，我比你爸都成熟";
        System.out.println(CoreSynonymDictionary.rewrite(text));
    }
}
