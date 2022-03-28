package com.belhard.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        Pattern regex = Pattern.compile("[A-z]+");
        MyCollection arrayOfWords = new MyDynamicArray();
        for (String s : str) {
            Matcher mat = regex.matcher(s);
            while (mat.find()) {
                arrayOfWords.add(mat.group());
            }
        }
        int numberOfSymbolInTheLongestWord = 1;
        for (int i = 0; i < arrayOfWords.size(); i++) {
            if (numberOfSymbolInTheLongestWord <= ((String) arrayOfWords.toArray()[i]).length()) {
                numberOfSymbolInTheLongestWord = ((String) arrayOfWords.toArray()[i]).length();
            }
        }
        MyCollection arrayOfWordsOfTheSameLength = new MyDynamicArray();
        for (int i = 0; i < arrayOfWords.size(); i++) {
            if (numberOfSymbolInTheLongestWord == ((String) arrayOfWords.toArray()[i]).length()) {
                arrayOfWordsOfTheSameLength.add(arrayOfWords.toArray()[i]);
            }
        }
        String[] wordsOfSameLength = new String[arrayOfWordsOfTheSameLength.size()];
        for (int i = 0; i < wordsOfSameLength.length; i++) {
            wordsOfSameLength[i] = (String) arrayOfWordsOfTheSameLength.toArray()[i];
        }
        int[] arrayOfCompareControl = new int[wordsOfSameLength.length];
        if (wordsOfSameLength.length == 1) {
            System.out.println(wordsOfSameLength[0]);
            return;
        } else {
            for (int i = 0; i < wordsOfSameLength.length; i++) {
                arrayOfCompareControl[i] = wordsOfSameLength[0].compareToIgnoreCase(wordsOfSameLength[i]);
            }
        }
        int minValue = 0;
        for (int j : arrayOfCompareControl) {
            if (minValue < j) {
                minValue = j;
            }
        }
        for (int i = 0; i < arrayOfCompareControl.length; i++) {
            if (minValue == arrayOfCompareControl[i]){
                System.out.println(wordsOfSameLength[i]);
                return;
            }
        }
    }
}
