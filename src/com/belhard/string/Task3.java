package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        Pattern regex = Pattern.compile("[\\d]");
        int counter = 0;
        for (String s : str) {
            Matcher matcher = regex.matcher(s);
            while (matcher.find()) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
