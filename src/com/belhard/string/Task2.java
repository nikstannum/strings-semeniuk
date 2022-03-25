package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        MyCollection processedArray = new MyDynamicArray();
        for (int i = 0; i < str.length; i++) {
            processedArray.add(str[i].replaceAll("\\W[b|B][L|l][A|a][C|c][K|k]\\W", " white "));
        }
        for (int i = 0; i < processedArray.size(); i++) {
            System.out.println(processedArray.toArray()[i]);
        }
    }
}
