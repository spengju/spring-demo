package com.peng.alg.sort;

import java.util.Arrays;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/11 09:55
 * @Desc: 选择排序
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort implements IArraySort{

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }
}
