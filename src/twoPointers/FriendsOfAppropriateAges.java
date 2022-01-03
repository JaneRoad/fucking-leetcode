package twoPointers;

public class FriendsOfAppropriateAges {
    int N = 130;
    public int numFriendRequests(int[] ages) {
        int[] nums = new int[N];
        for (int i : ages) nums[i]++;
        for (int i = 1; i < N; i++) nums[i] += nums[i - 1];
        int ans = 0;
        for (int y = 1, x = 1; y < N; y++) {
            int a = nums[y] - nums[y - 1]; // 有 a 个 y
            if (a == 0) continue;
            if (x < y) x = y;
            while (x < N && check(x, y)) x++;
            int b = nums[x - 1] - nums[y - 1] - 1; // [y, x) 为合法的 x 范围，对于每个 y 而言，有 b 个 x
            if (b > 0) ans += b * a;
        }
        return ans;
    }
    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }
}
