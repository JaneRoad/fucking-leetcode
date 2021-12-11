package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopVotedCandidate {
    List<Integer> tops;
    Map<Integer, Integer> voteCounts;
    int[] times;
    /**
     * @Author JaneRoad
     * @Description 911. 在线选举
     * @Date 12:54 2021/12/11
     * @Param
     * @param persons
     * @param times
     * @return
     * @return null
     **/
    public TopVotedCandidate(int[] persons, int[] times) {
        tops = new ArrayList<>();
        voteCounts = new HashMap<>();
        voteCounts.put(-1, -1);
        int top = -1;
        for (int i = 0; i < persons.length; ++i) {
            int p = persons[i];
            voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
            if (voteCounts.get(p) >= voteCounts.get(top)) {
                top = p;
            }
            tops.add(top);
        }
        this.times = times;
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        // 找到满足 times[l] <= t 的最大的 l
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return tops.get(l);
    }
}
