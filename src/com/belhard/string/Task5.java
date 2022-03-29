package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        MyCollection newArray = new MyDynamicArray();
        Pattern regex = Pattern.compile("\\w\\s\\W");
        for (int i = 0; i < str.length; i++) {
            String[] arrayTrim = new String[str.length];
            arrayTrim[i] = str[i].trim().replaceAll("\\s{2,}", " ");
            Matcher matcher = regex.matcher(arrayTrim[i]);
            if (matcher.find()) {
                String group = matcher.group().replaceAll(" ", "");
                String[] splitString = arrayTrim[i].split("\\w\\s\\W");
                String withoutWhiteSpace = "";
                for (String s : splitString) {
                    withoutWhiteSpace = withoutWhiteSpace.concat(s);
                }
                withoutWhiteSpace = withoutWhiteSpace.concat(group);
                newArray.add(withoutWhiteSpace);
                continue;
            }
            newArray.add(arrayTrim[i]);
        }
        for (int i = 0; i < newArray.size(); i++) {
            System.out.println(newArray.toArray()[i]);
        }
    }
}
