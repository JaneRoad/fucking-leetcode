package competition;

import java.util.*;

public class UAVPhalanx {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        if (source.length == 0){
            return 0;
        }
        int res = 0;
        ArrayList<Integer> sourceList = new ArrayList<>();
        ArrayList<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                sourceList.add(source[i][j]);
                targetList.add(target[i][j]);
            }
        }
        for (int i = 0; i < sourceList.size(); i++) {
            if (targetList.contains(sourceList.get(i))){
                targetList.remove(sourceList.get(i));
            }else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] source = new int[][]{{1,2},{3,4}};
        int[][] target = new int[][]{{3,3},{6,5}};
        UAVPhalanx u = new UAVPhalanx();
        System.out.println(u.minimumSwitchingTimes(source, target));
    }
}
