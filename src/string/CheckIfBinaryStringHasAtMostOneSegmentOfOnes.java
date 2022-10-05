package string;

/**
 * 1784. 检查二进制字符串字段
 *
 * @author janeroad
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        int n = s.length(), cnt = 0, idx = 0;
        while (idx < n && cnt <= 1) {
            while (idx < n && s.charAt(idx) == '0') {
                idx++;
            }
            if (idx < n) {
                while (idx < n && s.charAt(idx) == '1') {
                    idx++;
                }
                cnt++;
            }
        }
        return cnt <= 1;
    }


    public static void main(String[] args) {
        CheckIfBinaryStringHasAtMostOneSegmentOfOnes c = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        System.out.println(c.checkOnesSegment("1001"));
        System.out.println(c.checkOnesSegment("110"));
        System.out.println(c.checkOnesSegment("1111"));
        System.out.println(c.checkOnesSegment("1"));
    }
}
