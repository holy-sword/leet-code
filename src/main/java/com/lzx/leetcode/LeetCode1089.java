package com.lzx.leetcode;

import java.util.Arrays;

/**
 * 1089. 复写零
 * https://leetcode-cn.com/problems/duplicate-zeros/
 *
 * @author : lzx
 * created on 2019/9/30 1:06
 */
public class LeetCode1089 implements LeetCodeProblem {

    @Override
    public void execute(Object... args) {
        duplicateZeros((int[]) args[0]);
        System.out.println(Arrays.toString((int[]) args[0]));
    }

    /**
     * 双指针处理
     */
    public void duplicateZeros(int[] arr) {
        int end = 0;
        boolean zeroEnd = false;
        // 判断最后结果是否以0结尾，引发位数问题特殊处理
        for (int i = 0; i < arr.length; ) {
            if (arr[end++] == 0) {
                i += 2;
                if (i > arr.length)
                    zeroEnd = true;
            } else {
                i++;
            }
        }
        // 双指针回写
        for (int i = end - 1, j = arr.length - 1; i != j; i--) {
            if (j == arr.length - 1 && zeroEnd) {
                arr[j--] = 0;
            } else if (arr[i] == 0) {
                arr[j--] = 0;
                arr[j--] = 0;
            } else {
                arr[j--] = arr[i];
            }
        }
    }

    /**
     * 开始使用的字符串拼接处理方式
     */
    public void duplicateZerosTwo(int[] arr) {
        int length = arr.length;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0, j = 0; j < length; i++, j++) {
            if (arr[i] == 0) {
                sb.append("00");
                j++;
            } else {
                sb.append(arr[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            arr[i] = sb.charAt(i) - '0';
        }
    }

}
