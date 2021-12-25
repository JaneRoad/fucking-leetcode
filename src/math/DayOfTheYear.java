package math;

public class DayOfTheYear {
    /**
     * @Author JaneRoad
     * @Description 1154. 一年中的第几天
     * @Date 20:18 2021/12/21
     * @Param
     * @param null
     * @return
     * @return null
     **/
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] f = new int[13];
    static {
        for (int i = 1; i <= 12; i++) f[i] = f[i - 1] + nums[i - 1];
    }
    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        int y = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]), d = Integer.parseInt(ss[2]);
        boolean isLeap = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
        int ans = m > 2 && isLeap ? f[m - 1] + 1 : f[m - 1];
        return ans + d;
    }
}
