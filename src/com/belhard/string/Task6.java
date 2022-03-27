package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        Pattern regex1 = Pattern.compile("([^\\s]\\s+[^\\s])|([\\s]\\s+[^\\s])");
        MyCollection counterArray = new MyDynamicArray();
        for (String s : str) {
            int counter = 0;
            Matcher mat1 = regex1.matcher(s);
            while (mat1.find()) {
                String stringMatFind = mat1.group();
                Pattern regex2 = Pattern.compile("\\s");
                Matcher mat2 = regex2.matcher(stringMatFind);
                while (mat2.find()) {
                    counter++;
                }
                counterArray.add(counter);
                counter = 0;
            }
        }
        int maxCounter = 0;
        for(int i = 0; i < counterArray.size(); i++) {
            if (maxCounter < (int) counterArray.toArray()[i]){
                maxCounter = (int) counterArray.toArray()[i];
            }
        }
        System.out.println(maxCounter);
    }
}
