package com.peng.alg.sort;

import java.util.Arrays;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/11 09:51
 * @Desc:
 */
public class SortTest {
    public static void main(String[] args) throws Exception {
        int[] arr = {7, 1, 5, 3, 6, 4, 2, 8, 9};
//        Bubble.bubbleSort(arr);
        IArraySort arraySort = new InsertSort();
        int[] sort = arraySort.sort(arr);
        Arrays.stream(sort).forEach(System.out::println);

    }
}
