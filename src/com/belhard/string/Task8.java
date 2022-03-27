package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        Pattern regex = Pattern.compile("[A-z]{3,}");
        int counter = 0;
        for (String s : str) {
            Matcher mat = regex.matcher(s);
            while (mat.find()) {
                String word = mat.group();
                for (int i = 0; i < word.length() / 2; i++) {
                    if (word.charAt(i) == word.charAt(word.length() - 1 - i)) {
                        counter++;
                    }
                    if (counter == word.length() / 2) {
                        System.out.println(word);
                    }
                }
                counter = 0;
            }
        }
    }
}
