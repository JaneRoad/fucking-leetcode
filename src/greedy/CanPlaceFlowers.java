package greedy;

/**
 * 605. 种花问题
 * @author janeroad
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) {
                continue;
            }
            // 检查当前位置和相邻位置是否为空
            boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
            boolean nextEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

            if (prevEmpty && nextEmpty) {
                // 在当前位置放置一朵花
                flowerbed[i] = 1;
                count++;
            }
        }

        return count >= n;
    }
    public static void main(String[] args) {
        CanPlaceFlowers c  = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{ 0, 0}, 2));
    }
}
