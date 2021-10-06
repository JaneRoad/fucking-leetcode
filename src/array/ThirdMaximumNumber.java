package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }
}
