package com.belhard.string;

public class Task7 {
    public static void main(String[] args) {
        String[] str = DemoStrings.getStringsArray();
        MyCollection newArray = new MyDynamicArray();
        for (String s : str) {
            newArray.add(s.replaceAll("a", "ab"));
        }
        for (int i = 0; i < newArray.size();i++){
            System.out.println(newArray.toArray()[i]);
        }
    }
}
