package com.peng.alg.sort;

import java.util.Arrays;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/11 10:05
 * @Desc: 插入排序
 * <p>
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * <p>
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                //和其交换值
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }
}
