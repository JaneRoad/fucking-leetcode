package string;

public class Test {

    public String minimumString(String a, String b, String c) {
        String ab = findSupersequence(a, b);
        String bc = findSupersequence(b, c);
        String ac = findSupersequence(a, c);

        String shortest = ab;

        if (bc.length() < shortest.length()) {
            shortest = bc;
        }

        if (ac.length() < shortest.length()) {
            shortest = ac;
        }

        return shortest;
    }

    private String findSupersequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length(), j = b.length();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(a.charAt(i - 1));
                i--;
            } else {
                sb.append(b.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.minimumString("abc", "bca", "aaa"));
    }
}
