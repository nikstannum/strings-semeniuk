package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        MyCollection newArray = new MyDynamicArray();
        Pattern regex1 = Pattern.compile("\\w\\s\\W");
        for (int i = 0; i < str.length; i++) {
            String[] arrayTrim = new String[str.length];
            arrayTrim[i] = str[i].trim().replaceAll("\\s{2,}", " ");
            Matcher matcher1 = regex1.matcher(arrayTrim[i]);
            if (matcher1.find()) {
                String group = matcher1.group().replaceAll(" ", "");
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
        String[] newArr = new String[newArray.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = (String) newArray.toArray()[i];
        }
        Pattern regex2 = Pattern.compile("\\.\\s\\w");
        int counter = 0;
        for (String s : newArr) {
            Matcher matcher2 = regex2.matcher(s);
            while (matcher2.find()) {
                counter++;
            }
        }
        Pattern regex3 = Pattern.compile("\\w");
        for (String s : newArr) {
            Matcher matcher3 = regex3.matcher(s);
            if (matcher3.find()) {
                counter++;
            }

        }
        System.out.println(counter);
    }
}
