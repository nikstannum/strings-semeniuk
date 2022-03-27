package com.belhard.string;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {
    public static void main(String[] args) {
        System.out.print("Please, insert the letter you want to check: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        if (letter.length() > 1) {
            System.out.println("Error! You entered more than one character.");
            return;
        }
        if (!letter.matches("[A-z]")) {
            System.out.println("Error! You entered not letter.");
            return;
        }
        System.out.print("If you want to know how many times only the letter you entered appears " +
                "(case sensitive), insert 'Y', else insert 'N': ");
        String s = scanner.nextLine();
        if (s.toLowerCase(Locale.ROOT).equals("y")) {
            Pattern regex0 = Pattern.compile(letter);
            String[] str = DemoStrings.getStringsArray();
            for (int i = 0; i < str.length; i++) {
                Matcher mat0 = regex0.matcher(str[i]);
                int counter = 0;
                while (mat0.find()) {
                    counter++;
                }
                int numberString = i + 1;
                System.out.println("String " + numberString + " : letter " + "'" + letter + "'" + " occurs " + counter + " time.");
                counter = 0;
            }
        } else {
            Pattern regex1 = Pattern.compile(letter.toLowerCase());
            Pattern regex2 = Pattern.compile(letter.toUpperCase());
            String[] str = DemoStrings.getStringsArray();
            for (int i = 0; i < str.length; i++) {
                Matcher mat1 = regex1.matcher(str[i]);
                Matcher mat2 = regex2.matcher(str[i]);
                int counter = 0;
                while (mat1.find() || mat2.find()) {
                    counter++;
                }
                int numberString = i + 1;

                String upperCase = letter.toUpperCase();
                String lowerCase = letter.toLowerCase();
                System.out.println("String " + numberString + " : letter '" + upperCase + "' and letter '" + lowerCase
                        + "' occurs " + counter + " time.");
                counter = 0;
            }
        }
    }
}
