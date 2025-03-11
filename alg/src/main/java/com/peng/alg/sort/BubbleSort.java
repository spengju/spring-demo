package com.peng.alg.sort;

import java.util.Arrays;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/11 09:49
 * @Desc: 冒泡排序
 * <p>
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <p>
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * <p>
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort implements IArraySort {
    /**
     * 优化：设置标记
     *
     * @param sourceArray
     */
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
