package competition;

import java.util.*;

/**
 * 无人机方阵 比赛题
 */
public class UAVPhalanx {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int n=source.length,m=source[0].length,sum=0;
        int[] p=new int[10005];
        for(int i=0;i<n*m;i++){
            p[source[i/m][i%m]]++;
            p[target[i/m][i%m]]--;
        }
        for(int i=0;i<10005;i++){
            if(p[i]>0) sum+=p[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] source = new int[][]{{1,2},{3,4}};
        int[][] target = new int[][]{{3,3},{6,5}};
        UAVPhalanx u = new UAVPhalanx();
        System.out.println(u.minimumSwitchingTimes(source, target));
    }
}
