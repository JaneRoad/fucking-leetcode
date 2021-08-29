package backtracking;

public class NQueensII {
    private int size;
    private int count; //N皇后可能的解法数

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return count;
    }

    /**
     * @param row 当前这行的填充情况
     * @param ld  左对角线的填充情况
     * @param rd  有对角线的填充情况
     */
    private void dfs(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        //取得现在可以填充的位置，1表示可以填充的，0表示已经填充过了
        int pos = size & (~(row | ld | rd));

        while (pos != 0) {
            //取得pos的最后一位1，也就是这轮需要填充的位置
            int p = pos & -pos;
            //将pos的最后一位1置为0，表明我们将这个位置填充了
            pos &= pos - 1;
            //下探到下一层
            dfs(row | p, (ld | p) << 1, (rd | p) >> 1);
            //这里的回溯不需要再做什么操作，因为我们的或操作是不
            //改变row, ld, rd的值的
        }
    }
}
