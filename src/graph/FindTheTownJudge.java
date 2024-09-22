package graph;

/**
 * 997. 找到小镇的法官
 */
public class FindTheTownJudge {
    /**
     * 找到小镇的法官
     * 通过分析信任关系，找出那个被n-1个人信任但自己不信任任何人的法官
     * 如果不存在这样的法官，则返回-1
     *
     * @param n 小镇上的人数
     * @param trust 一个二维数组，其中每个trust[i] = [a, b]代表a信任b
     * @return 如果找到法官则返回法官的编号，否则返回-1
     */
    public int findJudge(int n, int[][] trust) {
        // 初始化两个数组，分别记录每个人的信任别人数和被信任数
        int[] in = new int[n + 1], out = new int[n + 1];

        // 遍历信任关系，更新每个人的信任别人数和被信任数
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            in[b]++; // b被信任数加1
            out[a]++; // a信任别人数加1
        }

        // 遍历所有人，寻找被n-1个人信任且自己不信任任何人的法官
        for (int i = 1; i <= n; i++) {
            // 如果找到满足条件的法官，返回其编号
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }

        // 如果没有找到法官，返回-1
        return -1;
    }

}
