# 题目

**类型：数组**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1642259781391-80a3c46d-1052-4219-ba44-19db8b73a67c.png)



# 解题思路

二分



将所有「数对和」按照升序排序，两端的值分别为 l = nums1[0] + nums2[0] 和 r = nums1[n - 1] + nums2[m - 1]

因此可以在值域 [l, r] 上进行二分，找到第一个满足「点对和小于等于 x 的，且数量超过 k 的值 x」。

之所以能够二分，是因为 x 所在的点对和数轴上具有二段性：

- 点对和小于 x 的点对数量少于 k 个；
- 点对和大于等于 x 的点对数量大于等于 k 个。



判定小于等于 x 的点对数量是否大于等于 k 个这一步可直接使用循环来做，由于二分是从中间值开始，这一步不会出现跑满两层循环的情况。

当二分出第 k 小的值为 x 后，由于存在不同点对的点对和值相等，我们需要先将所有点对和小于等于 x 的值加入答案，然后酌情把值等于 x 的点对加入答案，知道满足答案数量为 k。



找值为 x 的所有点对这一步，可以通过枚举 nums1[i] ，然后在 nums2  上二分目标值 x - nums1[i] 的左右端点来做。

最后，在所有处理过程中，都可以利用答案数组的大小与 k 的关系做剪枝。



# 代码

```java
class Solution {
    int[] nums1, nums2;
    int n, m;
    public List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
        nums1 = n1; nums2 = n2;
        n = nums1.length; m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums1[0] + nums2[0], r = nums1[n - 1] + nums2[m - 1];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, k)) r = mid;
            else l = mid + 1;
        }
        int x = r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] + nums2[j] < x) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]); temp.add(nums2[j]);
                    ans.add(temp);
                } else break;
            }
        }
        for (int i = 0; i < n && ans.size() < k; i++) {
            int a = nums1[i], b = x - a;
            int c = -1, d = -1;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums2[mid] >= b) r = mid;
                else l = mid + 1;
            }
            if (nums2[r] != b) continue;
            c = r;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums2[mid] <= b) l = mid;
                else r = mid - 1;
            }
            d = r;
            for (int p = c; p <= d && ans.size() < k; p++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(a); temp.add(b);
                ans.add(temp);
            }
        }
        return ans;
    }
    boolean check(int x, int k) {
        int ans = 0;
        for (int i = 0; i < n && ans < k; i++) {
            for (int j = 0; j < m && ans < k; j++) {
                if (nums1[i] + nums2[j] <= x) ans++;
                else break;
            }
        }
        return ans >= k;
    }
}
```