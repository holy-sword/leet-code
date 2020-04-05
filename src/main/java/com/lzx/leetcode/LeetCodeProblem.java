package com.lzx.leetcode;

/**
 * @author : lzx
 * @since 2019/9/14 16:57
 */
public interface LeetCodeProblem {

    String SATISFACTION_SSS = "SSS";
    String SATISFACTION_S = "S";
    String SATISFACTION_A = "A";
    String SATISFACTION_B = "B";
    String SATISFACTION_C = "C";

    /**
     * 执行
     *
     * @param args 参数数组
     */
    void execute(Object... args);

    /**
     * 解答满意程度（）
     */
    default String satisfaction() {
        return SATISFACTION_B;
    }


}
