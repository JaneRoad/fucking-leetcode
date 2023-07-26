package tree;

import java.util.*;

public class CountPathsThatCanFormAPalindromeInATree {
    /**
     * 计算回文路径的数量
     *
     * @param parent 树的父节点数组
     * @param s      表示边的字符的字符串
     * @return 回文路径的数量
     */
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        int[] route = new int[n];
        Arrays.fill(route, -1);
        // 根节点到根节点的路径，表示该路径上字符出现的频次
        route[0] = 0;
        for (int i = 1; i < n; i++) {
            // DFS遍历树，计算每个节点到根节点的路径的位掩码
            dfs(parent, s, i, route);
        }
        // 统计每个路径出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();
        // 根节点到根节点的路径，出现1次
        cnt.put(0, 1);

        long res = 0;
        for (int i = 1; i < n; i++) {
            // 加上当前路径出现的次数
            res += cnt.getOrDefault(route[i], 0);

            for (int k = 0; k < 26; k++) {
                // 如果当前路径上字符k的频次为奇数
                if ((route[i] & (1 << k)) != 0) {
                    // 加上字符k频次变为偶数的路径出现的次数
                    res += cnt.getOrDefault(route[i] ^ (1 << k), 0);
                } else {
                    // 如果当前路径上字符k的频次为偶数 加上字符k频次变为奇数的路径出现的次数
                    res += cnt.getOrDefault(route[i] | (1 << k), 0);
                }
            }
			// 将当前路径添加到哈希表中，以备后续使用
            cnt.put(route[i], cnt.getOrDefault(route[i], 0) + 1);
        }
        // 返回回文路径的数量
        return res;
    }

    /**
     * DFS遍历树，计算每个节点到根节点的路径的位掩码
     *
     * @param parent 树的父节点数组
     * @param s      表示边的字符的字符串
     * @param i      当前节点的索引
     * @param route  节点到根节点的路径的位掩码数组
     */
    void dfs(List<Integer> parent, String s, int i, int[] route) {
        // 已经到达根节点，返回
        if (i == 0) {
            return;
        }

        // 已经计算过该节点的路径，返回
        if (route[i] != -1) {
            return;
        }

        int p = parent.get(i);
        if (route[p] == -1) {
            // 递归计算父节点的路径
            dfs(parent, s, p, route);
        }
        int c = s.charAt(i) - 'a';
        // 当前节点的路径等于父节点的路径异或上当前节点的字符频次位掩码
        route[i] = route[p] ^ (1 << c);
    }



    public static void main(String[] args) {
        CountPathsThatCanFormAPalindromeInATree solution = new CountPathsThatCanFormAPalindromeInATree();

        List<Integer> parent = new ArrayList<>();
        parent.add(-1);
        parent.add(0);
        parent.add(0);
        parent.add(1);
        parent.add(1);
        parent.add(2);

        String s = "acaabc";

        long result = solution.countPalindromePaths(parent, s);
        System.out.println(result); // 输出：8
    }
}
