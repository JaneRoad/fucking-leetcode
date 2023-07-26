package hashTable;

import java.util.HashSet;

/**
 * 771. 宝石与石头
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        if (jewels.length() == 0 || stones.length() == 0) {
            return 0;
        }

        HashSet<Character> jewelSet = new HashSet<>();
        int count = 0;

        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aA";
        String s1 = "aaaaAABcsq";
        System.out.println(numJewelsInStones(s, s1));
    }
}
