package com.peng.alg.list;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/6 13:51
 * @Desc: 27.移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * <p>
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * <p>
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class Lc_27_removeElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
