package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        Pattern regex1 = Pattern.compile("[A-Z]");
        Pattern regex2 = Pattern.compile("[a-z]");
        int counter1 = 0;
        int counter2 = 0;
        for (String s : str) {
            Matcher mat1 = regex1.matcher(s);
            Matcher mat2 = regex2.matcher(s);
            while (mat1.find()) {
                counter1++;
            }
            while (mat2.find()) {
                counter2++;
            }
        }
        System.out.println("Number of uppercase letters: " + counter1);
        System.out.println("Number of lowercase letters: " + counter2);
    }
}
