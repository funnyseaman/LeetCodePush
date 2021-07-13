package jianzhi.p19;

import org.junit.Test;

public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 是否是空正则
                if (j == 0) {
                    dp[i][j] = (i == 0);
                } else {
                    // 是否是*
                    if (p.charAt(j - 1) == '*') {
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        if (match(s, p, i, j - 1)) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    } else {
                        if (match(s, p, i, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        } else {
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aaaa", "a*"));
        System.out.println(isMatch("", "a*"));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("dasdad", ".*"));
    }
}
