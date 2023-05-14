package prefixSum;

import java.util.Arrays;

/**
 * 1094 拼车
 * @author janeroad
 */
public class CarPooling {

    public static void main(String[] args) {
        CarPooling c = new CarPooling();
        int[][] trips = {{2,1,5}, {3,5,7}};
        System.out.println(c.carPooling(trips, 3));
    }
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000];
        Arrays.fill(diff, 0);
        diff[0] = - capacity;

        for (int[] t : trips) {
            int num = t[0];
            int i = t[1];
            int j = t[2];

            if (diff[i] != 0 || diff[j] != 0){
                if (hasOverRide(diff)) {
                    return false;
                }
                Arrays.fill(diff, 0);
                diff[0] = - capacity;
            }
            diff[i] = num;
            diff[j] = -num;
        }
        if (hasOverRide(diff)) {
            return false;
        }
        return true;
    }

    private boolean hasOverRide(int[] diff){
        int res = 0;
        for (int i = 0; i < diff.length; i++) {
            res = diff[i] + res;
            if (res > 0){
                return true;
            }
        }
        return false;
    }

}
