package graph;

public class FindCenterOfStarGraph {
    /**
     * @Author JaneRoad
     * @Description 1791. 找出星型图的中心节点
     * @Date 16:26 2022/2/19
     * @Param 
     * @param edges
     * @return 
     * @return int
     **/
    public int findCenter(int[][] edges) {
        int a = edges[0][0], b = edges[0][1];
        if (a == edges[1][0] || a == edges[1][1]) return a;
        else return b;
    }
    
}
