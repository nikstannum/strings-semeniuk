package com.belhard.string;

public class MyDynamicArray implements MyCollection {
    public static final int DEFAULT_INITIAL_SIZE = 2;
    private Object[] array = new Object[DEFAULT_INITIAL_SIZE];
    private int size;

    @Override
    public void add(Object obj) {
        if (size == array.length) {
            Object[] objects = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                objects[i] = array[i];
            }
            array = objects;
        }
        array[size++] = obj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        for (int i = 0; i < size; i++) {
            obj[i] = array[i];
        }
        return obj;
    }
}
