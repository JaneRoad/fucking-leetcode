package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(lists, board, n, 0);
        return lists;
    }

    public void backtrack(List<List<String>> lists, char[][] board, int n, int t) {
        if (t == n) { // 已经放置了n个皇后
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(board[i]));
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(board, t, i, n)) { // 判断当前位置是否可以放置皇后
                board[t][i] = 'Q';
                backtrack(lists, board, n, t + 1);
                board[t][i] = '.';
            }
        }
    }

    public boolean check(char[][] board, int i, int j, int n) {
        // each row is only one queen（行不需要判断，每行只能有一个皇后）
        // col（判断列）
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') return false;
        }

        // diagonal（对角线判断）
        for (int k = 1; k < n; k++) {
            // 主对角线
            if (i - k >= 0 && j - k >= 0 && board[i - k][j - k] == 'Q') return false;
            // 副对角线
            if (i - k >= 0 && j + k < n && board[i - k][j + k] == 'Q') return false;
        }

        return true;
    }
}
