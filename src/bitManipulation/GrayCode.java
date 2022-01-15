package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /**
     * @Author JaneRoad
     * @Description 89. 格雷编码
     * @Date 22:33 2022/1/9
     * @Param
     * @param n
     * @return
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        List<Integer> list = gc.grayCode(2);
    }
}
