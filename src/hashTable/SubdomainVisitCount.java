package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * @author janeroad
 */
public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] ss) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : ss) {
            // 当前元素的长度 n 、 指针 idx
            int n = s.length(), idx = 0;
            // idx定位到 空格符位置
            while (idx < n && s.charAt(idx) != ' ') {
                idx++;
            }
            //截取到空格符前的数字，数字是计数 cnt
            int cnt = Integer.parseInt(s.substring(0, idx));
            // 指针start指向 域名起始位置
            int start = idx + 1;
            // 指针idx指向 域名终点位置
            idx = n - 1;
            // 域名字符串内部双指针循环
            while (idx >= start) {
                while (idx >= start && s.charAt(idx) != '.') {
                    idx--;
                }
                String cur = s.substring(idx + 1);
                map.put(cur, map.getOrDefault(cur, 0) + cnt);
                idx--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}
