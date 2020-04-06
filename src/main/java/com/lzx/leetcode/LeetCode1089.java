package com.lzx.leetcode;

import java.util.Arrays;

/**
 * 1089. 复写零
 * <p>
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : lzx
 * @since 2019/9/30 1:06
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
