package greddy;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    /**
     * @Author JaneRoad
     * @Description 1414. 和为 K 的最少斐波那契数字数目
     * @Date 12:03 2022/2/3
     * @Param
     * @param k
     * @return
     * @return int
     **/
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (b <= k) {
            int c = a + b;
            a = b; b = c;
        }
        int ans = 0;
        while (k != 0) {
            if (k >= b) {
                k -= b; ans++;
            }
            int c = b - a;
            b = a; a = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK f = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK();
        System.out.println(f.findMinFibonacciNumbers(7));
    }
}
