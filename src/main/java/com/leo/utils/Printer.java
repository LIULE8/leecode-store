package com.leo.utils;

import java.util.StringJoiner;

public class Printer {

    public static void printArray(int[] a) {
        StringJoiner sj = new StringJoiner(",");
        for (int value : a) {
            sj.add(String.valueOf(value));
        }
        System.out.println(sj.toString());
    }
}
