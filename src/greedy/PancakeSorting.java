package greedy;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting {

    /**
     * @Author JaneRoad
     * @Description 969. 煎饼排序
     * @Date 10:04 2022/2/19
     * @Param 
     * @param arr
     * @return 
     * @return java.util.List<java.lang.Integer>
     **/
    // 煎饼排序
    // 这道题有这么一个提示：
    //      任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确
    // 提示你：用任何一种解法，只要能正确排序就行

    // 使用冒泡排序的思想，每一次把最大的扔在后面，排序剩下的子数组
    //      这道题是1 - n全排列 ，每次最大的就是 n - 1  -> 1
    // 举例： 3 2 4 1
    //       先找到 4 的位置，(翻转)将 4 放到 第一个位置 => 4 2 3 1
    //       (翻转) 0 - 4   =>1 3 2 4
    //       一次排序完成

    // 优化:比如 4 已经在它的位置上了，就不要再翻了
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new LinkedList<>();
        // 当前要排序的子数组下标为： 0 - max(不包括max)
        // 同时，由于全排列的原因：max 也是最大数字
        // 如果只剩 1 的话就不用排了
        for (int max = arr.length; max > 1; max--) {
            // 先找到当前要排序的数字=>最大数在哪
            int maxNumIndex;
            for (maxNumIndex = 0; arr[maxNumIndex] != max; maxNumIndex++) ;
            if (maxNumIndex == max - 1) {
                // 如果已经排好了，就不要排了
                continue;
            }
            // 如果当前要排序的数字，在 0 这个位置就省去了第一段排序
            // 否则就要换到 0 这个位置
            if (maxNumIndex != 0) {
                reverse(arr, 0, maxNumIndex);
                res.add(maxNumIndex + 1);
            }
            // 然后将 整个子数组反转
            reverse(arr, 0, max - 1);
            res.add(max);
        }
        return res;
    }

    private void reverse(int[] arr, int start, int end) {
        // 翻转 start 到 end 的数组
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
