package com.belhard.strings.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task15_2 {
    public static void main(String[] args) {
        String text = Text.getText();
        String[] arraySentences = text.split("(\\. )|(\\.\\n)");
        String[] finishedText = new String[arraySentences.length];
        Pattern regex1 = Pattern.compile("(([\\w]+[\\-][\\w]+)|[\\w]+)");
        int maxNumberSymbolsOfWord = 0;
        int counter = 0;
        for (int i = 0; i < arraySentences.length; i++) {
            Matcher mat1 = regex1.matcher(arraySentences[i]);
            while (mat1.find()) {
                counter++;
                if (maxNumberSymbolsOfWord < mat1.group().length()) {
                    maxNumberSymbolsOfWord = mat1.group().length();
                }
            }
            mat1.reset();
            while (maxNumberSymbolsOfWord != 0) {
                for (int j = 0; j < counter; j++) {
                    mat1.find();
                    if (maxNumberSymbolsOfWord == mat1.group().length()) {
                        finishedText[i] += mat1.group() + " ";
                    }
                }
                mat1.reset();
                maxNumberSymbolsOfWord--;
            }
            counter = 0;
        }
        for (String s: finishedText) {
            System.out.println(s.substring(4));
        }
    }
}
