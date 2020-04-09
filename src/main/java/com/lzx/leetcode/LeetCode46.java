package com.lzx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * -[
 * -  [1,2,3],
 * -  [1,3,2],
 * -  [2,1,3],
 * -  [2,3,1],
 * -  [3,1,2],
 * -  [3,2,1]
 * -]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : lzx
 * @since 2020/4/9 21:12
 */
public class LeetCode46 implements LeetCodeProblem {
    @Override
    public void execute(Object... args) {
        System.out.println(permute((int[]) args[0]));
    }

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;

        search(nums, new ArrayList<>());

        return result;
    }


    public void search(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) continue;
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(num);
            search(nums, integers);

        }


    }

}
