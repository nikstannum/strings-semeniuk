package com.belhard.string;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {
        Pattern regex1 = Pattern.compile("([a-z]+[A-Z])+[a-z]*");
        String[] str = DemoStrings.getStringsArray();
        MyCollection arrayOfIndividualLexicalConstructs = new MyDynamicArray();
        for (String value : str) {
            String[] stringSplit = value.split("\\W+");
            for (String s : stringSplit) {
                arrayOfIndividualLexicalConstructs.add(s);
            }
        }
        MyCollection arrayCamelCase = new MyDynamicArray();
        for (int i = 0; i < arrayOfIndividualLexicalConstructs.size(); i++) {
            if (arrayOfIndividualLexicalConstructs.toArray()[i] instanceof String) {
                Matcher matcher = regex1.matcher((String) arrayOfIndividualLexicalConstructs.toArray()[i]);
                if (matcher.matches()) {
                    arrayCamelCase.add(arrayOfIndividualLexicalConstructs.toArray()[i]);
                }
            }
        }
        MyCollection arraySnakeCase = new MyDynamicArray();
        for (int i = 0; i < arrayCamelCase.size(); i++) {
            arraySnakeCase.add(((String) arrayCamelCase.toArray()[i]).replaceAll("[A-Z]", "_$0").toLowerCase(Locale.ROOT));
        }
        for (int i = 0; i < arraySnakeCase.size(); i++) {
            System.out.println((String) arraySnakeCase.toArray()[i]);
        }
    }
}
