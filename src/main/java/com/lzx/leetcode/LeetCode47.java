package com.lzx.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * -[
 * -  [1,1,2],
 * -  [1,2,1],
 * -  [2,1,1]
 * -]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : lzx
 * @since 2020/4/9 21:15
 */
public class LeetCode47 implements LeetCodeProblem {
    @Override
    public void execute(Object... args) {
        System.out.println(permuteUnique((int[]) args[0]));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return result;

        search(nums, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }


    public void search(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }

        //去除重复出现的元素
        Set<Integer> currentUsed = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            //是否使用过
            if (used[i]) continue;
            //判断该元素是否前面出现过
            if (currentUsed.contains(nums[i])) {
                continue;
            } else {
                currentUsed.add(nums[i]);
            }

            ArrayList<Integer> integers = new ArrayList<>(list);
            boolean[] uses = new boolean[nums.length];
            System.arraycopy(used, 0, uses, 0, nums.length);
            integers.add(nums[i]);
            uses[i] = true;
            search(nums, integers, uses);
        }


    }
}
