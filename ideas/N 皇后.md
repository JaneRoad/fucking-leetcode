# 题目

**类型：**回溯

**难度：**难

![image-20210829232323926](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210829232323926.png)







# 解题思路

在n×n格的棋盘上放置彼此不受攻击的n个皇后。按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。所以N皇后问题等价于在n×n格的棋盘上放置n个皇后，任何2个皇后不放在同一行或同一列或同一斜线上。



- 从n×n个格子中选择n个格子摆放皇后。可见解空间树为子集树。
- 使用`board[N][N]`来表示棋盘，`board[i][j]=.` 表示`(i,j)`位置为空，`board[i][j]=Q `表示`(i,j)`位置摆放有一个皇后。
- 使用`backtrack(t)`来摆放第t个皇后。`backtrack(t)` 函数符合子集树时的递归回溯范式。t从0开始，当`t==N`时，说明所有皇后都已经摆放完成，这是一个可行的摆放方法，记录结果；否则，遍历棋盘，找皇后t所有可行的摆放位置，`check(i,j)` 判断皇后t能否摆放在位置`(i,j)`处，如果可以摆放则继续递归摆放皇后`t+1`，如果不能摆放，则判断下一个位置。
- 由于每一行只放一个皇后，所以不需要进行每一行的判断，`check(row,col)`函数首先判断在当前col处是否已有皇后，有则冲突，返回false，无则继续判断斜方向（两条对角线）是否冲突。斜方向分为左上角、左下角、右上角、右下角四个方向，每次从（row,col）向四个方向延伸一个格子，判断是否冲突。如果所有方向都没有冲突，则返回true，表示此位置可以摆放一个皇后。

 







# 代码

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> lists = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(lists, board, n, 0);
        return lists;
    }

    public void backtrack(List<List<String>> lists, char[][] board, int n, int t) {
        if (t == n) { // 已经放置了n个皇后
            List<String> list = new ArrayList<String>();
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

```

