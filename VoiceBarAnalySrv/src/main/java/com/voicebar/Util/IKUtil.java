package com.voicebar.Util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IKUtil {
    private static Analyzer anal = new IKAnalyzer(true);
    public static List<String> getIKWord(String word){
        List<String> resultlist = new ArrayList<String>();

        StringReader reader = new StringReader(word);

        //分词
        TokenStream ts = null;
        ts = anal.tokenStream("",reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);

        try {
            while(ts.incrementToken()){
                String result = term.toString();
                resultlist.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        return resultlist;
    }
}
