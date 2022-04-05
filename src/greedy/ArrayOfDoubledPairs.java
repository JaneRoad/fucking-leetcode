package greedy;

import java.util.*;

public class ArrayOfDoubledPairs {
    static int N = 100010, M = 2 * N;
    static int[] cnts = new int[M * 2], in = new int[M * 2];
    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(cnts, 0);
        Arrays.fill(in, 0);
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (++cnts[i + M] == 1 && i != 0) list.add(i);
        }
        if (cnts[M] % 2 != 0) return false;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i : list) {
            if (i % 2 == 0) {
                in[i + M] = cnts[i / 2 + M];
                if (in[i + M] == 0) d.addLast(i);
            } else {
                d.addLast(i);
            }
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            if (cnts[t * 2 + M] < cnts[t + M]) return false;
            cnts[t * 2 + M] -= cnts[t + M];
            in[t * 2 + M] -= cnts[t + M];
            if (in[t * 2 + M] == 0 && cnts[t * 2 + M] != 0) d.addLast(t * 2);
            in[t * 4 + M] -= cnts[t + M];
            if (in[t * 4 + M] == 0 && cnts[t * 4 + M] != 0) d.addLast(t * 4);
        }
        return true;
    }
}
