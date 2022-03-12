package tree;

import java.util.Arrays;

public class CountNodesWithTheHighestScore {
    static int N = 100010, M = N * 2;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] f = new int[N];
    int idx;  //成员变量idx 默认初始值0，对边进行编号
    //建邻接图
    void add(int a, int b) {
        e[idx] = b; //当前idx边指向的节点
        ne[idx] = he[a]; //下一条边 若为-1则表示没有下一个了
        he[a] = idx++; //头结点
    }
    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(he, -1);  //初始化让所有边都没有下一条
        int n = parents.length;  //节点数目
        for (int i = 1; i < n; i++) add(parents[i], i); //建图
        dfs(0);//从根节点开始dfs，在搜索过程中存储当前节点的子树节点数目（含当前节点）
        long max = 0; //最坑的一个点,使用int会溢出,必须使用long
        int ans = 0; //最高得分计数
        for (int x = 0; x < n; x++) {
            long cur = 1;
            //删除节点x
            for (int i = he[x]; i != -1; i = ne[i]) cur *= f[e[i]]; //累乘删除的左右子树数量
            if (x != 0) cur *= n - f[x]; //如果不是根节点，还要再把上方剩余子树的n - f[x]个节点数量相乘
            if (cur > max) {
                //比之前的乘积大就替换,并把数量置1
                max = cur; ans = 1;
            } else if (cur == max) {
                //跟之前的最大值一样大,则数量+1
                ans++;
            }
        }
        return ans;
    }
    //递归函数
    int dfs(int u) {
        int ans = 1;//因为是依据边访问点,说明有一定有一个节点,所以至少都是1
        for (int i = he[u]; i != -1; i = ne[i]) ans += dfs(e[i]);//把子树的数目加上来
        f[u] = ans;//存储以u为根节点的树的节点数目
        return ans;
    }
}
