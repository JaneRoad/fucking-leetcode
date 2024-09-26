package array;

/**
 * 2535. 数组元素和与数字和的绝对差
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/26 08:02
 */
public class DifferenceBetweenElementSumAndDigitSumOfAnArray {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;  // 元素和
        int digitSum = 0;    // 数字和

        // 遍历每个元素
        for (int num : nums) {
            elementSum += num;  // 累加元素和

            // 对当前元素的每一位进行拆分并累加到数字和
            while (num > 0) {
                digitSum += num % 10;  // 获取最后一位
                num /= 10;             // 去掉最后一位
            }
        }

        // 计算元素和与数字和的绝对差
        return Math.abs(elementSum - digitSum);
    }
}
