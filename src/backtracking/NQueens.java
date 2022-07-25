package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class NQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 记录「路径」
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(res, board, n, 0);
        return res;
    }

    /**
     * 路径：记录在 board 中
     * 选择列表： 第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     *
     * @param res
     * @param board
     * @param n
     * @param row
     */
    public void backtrack(List<List<String>> res, char[][] board, int n, int row) {
        // 已经放置了n个皇后-触发结束条件
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(board[i]));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            // 判断当前位置是否可以放置皇后-排除不合法的选择
            if (!isValid(board, row, col, n)) {
                continue;
            }
            // 做选择-放棋子
            board[row][col] = 'Q';
            // 进入下一层决策树
            backtrack(res, board, n, row + 1);
            // 取消选择
            board[row][col] = '.';
        }
    }

    /**
     * 判断当前位置是否可以放置皇后
     *
     * @param board
     * @param row
     * @param col
     * @param n
     * @return
     */
    public boolean isValid(char[][] board, int row, int col, int n) {
        // 行不需要判断，每行只能有一个皇后

        // 判断列
        for (int cur = 0; cur < row; cur++) {
            if (board[cur][col] == 'Q') return false;
        }

        // 对角线判断
        for (int cur = 1; cur < n; cur++) {
            // 主对角线
            if (row - cur >= 0 && col - cur >= 0 && board[row - cur][col - cur] == 'Q') {
                return false;
            }
            // 副对角线
            if (row - cur >= 0 && col + cur < n && board[row - cur][col + cur] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
