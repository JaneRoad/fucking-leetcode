package dynamicProgramming;

/**
 * 902. 最大为 N 的数字组合
 * @author janeroad
 */
public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] nc = String.valueOf(n).toCharArray();
        int result = 0, ncl = nc.length, dl = digits.length;
        // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 1; i < ncl; i++) {
            result += Math.pow(dl, i);
        }
        for (int i = 0; i < ncl; i++) {
            // 是否需要对比下一个数字
            boolean compareNext = false;
            for (String digit : digits) {
                // 将String转换为char
                char dc = digit.charAt(0);
                if (dc < nc[i]) {
                    result += Math.pow(dl, ncl - i - 1);
                } else {
                    if (dc == nc[i]) {
                        compareNext = true;
                    }
                    break;
                }
            }
            if (!compareNext) {
                return result;
            }
        }
        // 如果到最后1位依然满足compareNext，因为最后1位无法再向后对比了，所以最终结果+1
        return ++result;
    }
}
