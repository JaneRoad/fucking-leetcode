# 题目

**类型：**回溯

**难度：**难



![image-20210829233818739](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210829233818739.png)





# 解题思路

这道题和「51. N 皇后」非常相似，区别在于，第 51 题需要得到所有可能的解，这道题只需要得到可能的解的数量。因此这道题可以使用第 51 题的做法，只需要将得到所有可能的解改成得到可能的解的数量即可。











# 代码

```java
class Solution {
    private int size;  
    private int count; //N皇后可能的解法数

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return count;
    }

    /**
     * 
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
```









另类解法：

背答案

~~~java
class Solution {
    public int totalNQueens(int n) {
        int result[] = {1, 0, 0 ,2, 10, 4, 40, 92, 352};
        return result[n - 1];
    }
}
~~~

