package math;

public class ComplexNumberMultiplication {

    /**
     * @Author JaneRoad
     * @Description 537. 复数乘法
     * @Date 11:04 2022/2/26
     * @Param 
     * @param num1
     * @param num2
     * @return 
     * @return java.lang.String
     **/
    public String complexNumberMultiply(String num1, String num2) {
        String[] ss1 = num1.split("\\+|i"), ss2 = num2.split("\\+|i");
        int a = parse(ss1[0]), b = parse(ss1[1]);
        int c = parse(ss2[0]), d = parse(ss2[1]);
        int A = a * c - b * d, B = b * c + a * d;
        return A + "+" + B + "i";
    }
    int parse(String s) {
        return Integer.parseInt(s);
    }
}
