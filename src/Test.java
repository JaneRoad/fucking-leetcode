import java.util.HashMap;

public class Test {


    public static long maximumTripletValue(int[] nums) {
        long res = 0L;

        if (nums.length == 3) {
            long l = Long.valueOf(nums[0]) - Long.valueOf(nums[1]);

            res =  l * Long.valueOf(nums[2]);
            if (res < 0) {
                return 0;
            }
            return res;
        }

        HashMap<Integer, Integer> maxMap = new HashMap<>();
        HashMap<Integer, Integer> minMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            minMap.putIfAbsent(i, Integer.MAX_VALUE);
            maxMap.putIfAbsent(i, Integer.MIN_VALUE);

            for (int i1 = i + 1; i1 < nums.length; i1++) {
                minMap.putIfAbsent(i1, Integer.MAX_VALUE);
                maxMap.putIfAbsent(i1, Integer.MIN_VALUE);
                for (Integer index : minMap.keySet()) {
                    if (index < i1 && nums[index] > nums[i1] && (Integer.MAX_VALUE == minMap.get(index) || (nums[i1] <= nums[minMap.get(index)] && i1>minMap.get(index)))) {
                        minMap.put(index,  i1);
                    }
                    if (index < i1 && (maxMap.get(index) == Integer.MIN_VALUE  || (nums[maxMap.get(index)] <= nums[i1] && maxMap.get(index) < i1))) {
                        maxMap.put(index, i1);
                    }
                }
            }

            for (int i2 = i - 1; i2 > 0; i2--) {
                minMap.putIfAbsent(i2, Integer.MAX_VALUE);
                maxMap.putIfAbsent(i2, Integer.MIN_VALUE);
                for (Integer index : minMap.keySet()) {
                    if (index < i2 && nums[index] > nums[i2] && (Integer.MAX_VALUE == minMap.get(index) || (nums[i2] <= nums[minMap.get(index)] && i2>minMap.get(index)))) {
                        minMap.put(index,  i2);
                    }
                    if (index < i2 && (maxMap.get(index) == Integer.MIN_VALUE  || (nums[maxMap.get(index)] <= nums[i2] && maxMap.get(index) < i2))) {
                        maxMap.put(index, i2);
                    }
                }
            }

        }

        for (int i = 0; i < nums.length; i++) {
            Integer i1 = minMap.get(i);
            Integer i2 = maxMap.get(i);
			if (i1 >= i2){
               continue;
            }
            long i3 = (long)(nums[i] - nums[i1]) * nums[i2];
            res = Math.max(i3, res);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{6,14,20,19,19,10,3,15,12,13,8,1,2,15,3}));
    }
}
