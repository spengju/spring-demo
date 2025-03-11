package com.peng.alg.sort;

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
public class SelectionSort {
    public static void sort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sourceArray.length; j++) {
                if (sourceArray[j] < sourceArray[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = sourceArray[i];
                sourceArray[i] = sourceArray[minIndex];
                sourceArray[minIndex] = tmp;
            }
        }
    }
}
