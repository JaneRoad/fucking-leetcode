# 题目

**类型：Array**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635167889911-bdfe32dc-39be-465a-8538-6c48025b32b8.png)



# 解题思路

可以从矩阵 matrix 的右上角 (0, n-1) 进行搜索。在每一步的搜索过程中，如果位于位置  (x,y)，那么希望在以 matrix 的左下角为左下角、以 (x,y) 为右上角的矩阵中进行搜索，即行的范围为 [x,m−1]，列的范围为 [0,y]：

如果   matrix[x,y] = target，说明搜索完成；

如果   matrix[x,y] > target，由于每一列的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第 y 列的元素都是严格大于 target 的，因此可以将它们全部忽略，即将 y 减少 1；

如果   matrix[x,y] < target，由于每一行的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第 x 行的元素都是严格小于 target 的，因此可以将它们全部忽略，即将 x 增加 1。

在搜索的过程中，如果超出了矩阵的边界，那么说明矩阵中不存在 target。





# 代码

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
```