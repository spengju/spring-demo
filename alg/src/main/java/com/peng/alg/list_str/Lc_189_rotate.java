package com.peng.alg.list_str;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/6 16:08
 * @Desc: 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class Lc_189_rotate {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int end = nums[n - 1];
        for (int i = 0; i < k; i++) {
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = end;
            end = nums[n - 1];
        }
    }
}
