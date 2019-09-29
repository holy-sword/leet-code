package com.lzx.leetcode;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @author : lzx
 * created on 2019/9/14 16:56
 */
public class LeetCode557 implements LeetCodeProblem {

    @Override
    public void execute(Object... args) {
        System.out.println(reverseWords((String) args[0]));
    }


    /**
     * 双指针
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            int start = i;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            int end = i - 1;
            while (start < end) {
                chars[start] = (char) (chars[start] ^ chars[end]);
                chars[end] = (char) (chars[start] ^ chars[end]);
                chars[start] = (char) (chars[start] ^ chars[end]);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

}
