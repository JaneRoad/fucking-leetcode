package bitManipulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,2,5};
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        int[] res = singleNumberIII.singleNumber(arr);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
