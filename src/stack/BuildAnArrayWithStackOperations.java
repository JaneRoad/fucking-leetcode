package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * @author janeroad
 */
public class BuildAnArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int m = target.length;
        for (int i = 1, j = 0; i <= n && j < m; i++) {
            ans.add("Push");
            if (target[j] != i) {
                ans.add("Pop");
            } else {
                j++;
            }
        }
        return ans;
    }
}
