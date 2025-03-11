package com.peng.alg.sort;

import java.util.Arrays;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/11 09:51
 * @Desc:
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        Bubble.bubbleSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
