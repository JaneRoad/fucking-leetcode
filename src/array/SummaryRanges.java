package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int left = nums[0];
        int right = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1) {
                right = nums[i];
            } else {
                if (left == right) {
                    res.add(String.valueOf(left));
                } else {
                    res.add(left + "->" + right);
                }
                left = right = nums[i];
            }
        }

        if (left == right) {
            res.add(String.valueOf(left));
        } else {
            res.add(left + "->" + right);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 2, 3, 4, 6, 7, 8};
        SummaryRanges s = new SummaryRanges();
        System.out.println(s.summaryRanges(ints));
    }
}
