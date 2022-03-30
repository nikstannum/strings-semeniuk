package com.belhard.strings.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task15_1 {
    public static void main(String[] args) {
        String str = Text.getText();
        Pattern regex = Pattern.compile("[A-Z][^.]*\\.");
        String[] arrayOfParagraphs = str.split("\\n");
        int[] arrayOfNumbersOfSentencesInTheParagraph = new int[arrayOfParagraphs.length];
        int counter = 0;
        for (int i = 0; i < arrayOfParagraphs.length; i++) {
            Matcher mat2 = regex.matcher(arrayOfParagraphs[i]);
            while (mat2.find()) {
                counter++;
            }
            arrayOfNumbersOfSentencesInTheParagraph[i] = counter;
            counter = 0;
        }
        StringBuilder newText = new StringBuilder();
        int maxArrayOfNumbersOfSentencesInTheParagraph = 0;
        for (int j : arrayOfNumbersOfSentencesInTheParagraph) {
            if (maxArrayOfNumbersOfSentencesInTheParagraph < j) {
                maxArrayOfNumbersOfSentencesInTheParagraph = j;
            }
        }
        while (maxArrayOfNumbersOfSentencesInTheParagraph != 0) {
            for (int i = 0; i < arrayOfNumbersOfSentencesInTheParagraph.length; i++) {
                if (maxArrayOfNumbersOfSentencesInTheParagraph == arrayOfNumbersOfSentencesInTheParagraph[i]) {
                    newText.append(arrayOfParagraphs[i]).append("\n");
                }
            }
            maxArrayOfNumbersOfSentencesInTheParagraph--;
        }
        System.out.println(newText);
    }
}
