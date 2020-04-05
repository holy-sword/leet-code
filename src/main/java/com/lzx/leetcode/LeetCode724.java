package com.lzx.leetcode;

/**
 * 724. 寻找数组的中心索引
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author : lzx
 * @since 2019/9/29 23:35
 */
public class LeetCode724 implements LeetCodeProblem {

    @Override
    public void execute(Object... args) {
        System.out.println(pivotIndex((int[]) args[0]));
    }


    /**
     * 动态规划
     */
    public int pivotIndex(int[] nums) {
        //sum[0]位标识位,sum[1]存放nums中第一位的值（nums[0]）
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == sum[nums.length] - sum[i + 1])
                return i;
        }
        return -1;
    }

}
