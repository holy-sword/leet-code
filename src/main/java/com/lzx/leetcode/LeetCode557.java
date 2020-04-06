package com.lzx.leetcode;

/**
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : lzx
 * @since 2019/9/14 16:56
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
