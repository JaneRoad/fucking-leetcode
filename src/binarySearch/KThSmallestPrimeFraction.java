package binarySearch;


public class KThSmallestPrimeFraction {
    /**
     * @Author JaneRoad
     * @Description 0786 第 K 个最小的素数分数
     * @Date 22:02 2021/11/29
     * @Param 
     * @param arr
     * @param k
     * @return 
     * @return int[]
     **/
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while (true) {
            //猜测可能的小数值
            double mid = (left + right) / 2;
            int i = -1, count = 0;
            // 记录最大的分数
            int x = 0, y = 1;

            //计算有多少个小数比它小
            //此处运用了分数的两个特性：
            //1. 分母不变，分子越大分数越大a[i+1]/a[j]>a[i]/a[j].对于分母固定的情况，当a[i]/a[j]>t时，必然满足a[i+1]/a[j]>t,即不可能在不改变分母的情况通过向又移动分子的方式找到小于t的值,此时需向右移动j寻找;
            //2. 分子不变，分母越大分数越小a[i]/a[j+1]<a[i]/a[j].也就是说对于a[i]/a[j],如果满足a[i]/a[j]<t，则一定有a[i]/a[j+1]<t，这意味着移动分母j后，分子指针i可以向右继续寻找,而无需从头查找;
            for (int j = 1; j < n; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    //记录最大值，其实也是特性，1/3<1/2,满足左上*右下<右上*左下
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }

            //刚好给出的小数，能刚好把分数分为[k个小于小数]小数[剩余大于小数]，则第k个一定是答案
            if (count == k) {
                return new int[]{x, y};
            }

            //特别注意，此处mid不要+1、-1，因为非整数，left/right不等的情况，等号赋值，不会出死循环
            //数量不足，说明猜测的实数小了，考虑更大值
            if (count < k) {
                left = mid;
            } else {
                //数量太多，说明猜测的实数大了，考虑更小值
                right = mid;
            }
        }
    }

    public static void main(String[] args) {
        KThSmallestPrimeFraction k = new KThSmallestPrimeFraction();
        int[] arr = k.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
