package hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {
    int m, n, cnt; // cnt 为剩余数个数，同时 cnt - 1 为区间右端点位置
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random(300);
    public RandomFlipMatrix(int _m, int _n) {
        m = _m; n = _n; cnt = m * n;
    }
    public int[] flip() {
        int x = random.nextInt(cnt--);
        int idx = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(cnt, cnt));
        return new int[]{idx / n, idx % n};
    }
    public void reset() {
        cnt = m * n;
        map.clear();
    }
}
