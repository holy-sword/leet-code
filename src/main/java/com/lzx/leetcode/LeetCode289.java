package com.lzx.leetcode;

/**
 * 289. 生命游戏
 * <p>
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *  
 * 示例：
 * <p>
 * 输入：
 * -[
 * -  [0,1,0],
 * -  [0,0,1],
 * -  [1,1,1],
 * -  [0,0,0]
 * -]
 * 输出：
 * -[
 * -  [0,0,0],
 * -  [1,0,1],
 * -  [0,1,1],
 * -  [0,1,0]
 * -]
 *  
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : lzx
 * @since 2020/4/8 20:13
 */
public class LeetCode289 implements LeetCodeProblem {
    @Override
    public void execute(Object... args) {
        gameOfLife((int[][]) args[0]);
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = aliveAroundCount(board, j, i);
                if (board[i][j] == 0) {
                    if (count == 3) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                } else {
                    if (count < 2 || count > 3) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
        }
        String result = sb.toString();
        System.out.println(result);
        //渲染
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = result.charAt(board[0].length * i + j) == '0' ? 0 : 1;
            }
        }
    }

    public int aliveAroundCount(int[][] board, int x, int y) {
        int count = 0;
        for (int i = Math.max(0, y - 1); i <= Math.min(y + 1, board.length - 1); i++) {
            for (int j = Math.max(0, x - 1); j <= Math.min(x + 1, board[0].length - 1); j++) {
                count += board[i][j];
            }
        }
        return count - board[y][x];
    }
}
