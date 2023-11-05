# 题目

**类型：广度优先搜索**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1642832082856-071435de-5ca4-4b1f-8c28-d32dfa0424fc.png)



# 解题思路

1、使用「哈希表」记录某个值有哪些下标

2、进行BFS，假如当前走到的位置为 t，将 t - 1、t + 1 和与 arr[t] 等值的位置进行入队，为了防止重复同队使用 dist 数组记录到达某个位置的最小步数（初始化为 INF），只有 dist[ne] 为 INF 时，该点没有被遍历过，可以入队并更新最小步数。

3、光使用 dist 还不能确保复杂度为 O(n)，因为每次都需要遍历与 arr[t] 等值的下标，为确保等值下标的遍历只会发生一次，需要在将等值下标添加到队列后，将 arr[t] 从哈希表中移除

首次检索到 arr[t] 值时，必然是最小步数，记为 step ，此时 BFS 做法将其他等值下标距离更新为 step + 1 

- 若 arr[t] 与结尾元素值相等，且 t 为 n - 1，此时 step 即是答案；
- 若 arr[t] 与结尾元素值相等，但 t 不为 n - 1，此时会再跳一步到达结尾位置，即 step + 1 为答案。那么是否可能存在使用比 step + 1 更小的步数，也能到达结尾的位置呢？可能存在，但如果最后是通过「等值跳」到达结尾位置的话，不可能存在比 step + 1 更小的步数。由于我们每次加入等值时都会进行哈希表的移除，因此到达 t 的方式不可能是「等值跳」，而只能是「前后跳」。

- - 假设是通过前跳到达位置 t，即点分布如图，步数满足等于 step + 1：

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1642833270848-062babfa-34e1-450a-b446-e3eef8f36692.png)

- - 假设是通过后跳到达位置 t，即点分布如图，步数满足「如果是等值跳到达结尾，步数为 step + 1」：

 	![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1642833952622-3d46222a-5294-43fe-92e2-81e43ce0781d.png)

综上，如果 n - 1 是经过「等值跳」加入队列的话，起所能达到的最小步数必然为发起点 t 的最小步数 +1。

也就是说，即使首次等值跳，加入队列后会将其从哈希表中进行移除，正确性也是可以保证的。

基于此，可以额外增加一个 trick，就是在构建哈希表的时候，使用「倒序」的形式构建等值下标列表，这样可以确保如果最后位置是通过「等值跳」而来是，能够优先出队。







# 代码

```java
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxSameValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            idxSameValue.putIfAbsent(arr[i], new ArrayList<Integer>());
            idxSameValue.get(arr[i]).add(i);
        }
        Set<Integer> visitedIndex = new HashSet<Integer>();
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0});
        visitedIndex.add(0);
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int v = arr[idx];
            step++;
            if (idxSameValue.containsKey(v)) {
                for (int i : idxSameValue.get(v)) {
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                idxSameValue.remove(v);
            }
            if (idx + 1 < arr.length && visitedIndex.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }
}
```