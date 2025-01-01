package math;

/**
 * 3280. 将日期转换为二进制表示
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2025/1/1 22:54
 */
public class ConvertDateToBinary {
    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        if (split.length != 3) {
            return "";
        }
        String year = split[0];
        String month = split[1];
        String day = split[2];
        return binaryConversion(year) + "-" + binaryConversion(month) + "-" + binaryConversion(day);
    }


    /**
     * 将十进制字符串转换为二进制
     * @param s 十进制字符串
     * @return 二进制字符串
     */
    public String binaryConversion(String s){
        return Integer.toBinaryString(Integer.parseInt(s));
    }


    public static void main(String[] args) {
        // 测试用例
        ConvertDateToBinary solution = new ConvertDateToBinary();
        System.out.println(solution.convertDateToBinary("2025-01-01")); // 输出: 11111100001-1-1

    }
}
