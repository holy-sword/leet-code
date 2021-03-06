package com.lzx.leetcode.interview;

import com.lzx.leetcode.LeetCodeProblem;

import java.util.Arrays;

/**
 * 面试题54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * -   3
 * -  / \
 * - 1   4
 * -  \
 * -   2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * -       5
 * -      / \
 * -     3   6
 * -    / \
 * -   2   4
 * -  /
 * - 1
 * 输出: 4
 * <p>
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * @author : lzx
 * @since 2020/4/5 20:36
 */
public class LeetCodeInterview54 implements LeetCodeProblem {

    @Override
    public void execute(Object... args) {
        System.out.println(kthLargest((TreeNode) args[0], (int) args[1]));
    }


    public int kthLargest(TreeNode root, int k) {
        int[] arr = new int[k];
        Arrays.fill(arr, Integer.MIN_VALUE);
        find(arr, root);
        return arr[k - 1];
    }

    public void find(int[] arr, TreeNode node) {

        if (node == null) return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < node.val) {
                //后续移位
                if (arr.length - 1 - i >= 0) System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
                arr[i] = node.val;
                break;
            }
        }
        find(arr, node.left);
        find(arr, node.right);

    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
