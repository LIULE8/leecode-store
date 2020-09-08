package com.leo.algorithm.utils;

public class SortUtils {
    public static void insertionSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 0; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 移动数据
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }
}
