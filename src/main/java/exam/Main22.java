package exam;

import java.util.Scanner;

public class Main22 {
    // 1,5,10,20,50,100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[7][n + 1];
        // 初始化dp
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i - j * 5 >= 0; j++) {
                dp[2][i] += dp[1][i - j * 5];
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i - j * 10 >= 0; j++) {
                dp[3][i] += dp[2][i - j * 10];
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i - j * 20 >= 0; j++) {
                dp[4][i] += dp[3][i - j * 20];
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i - j * 50 >= 0; j++) {
                dp[5][i] += dp[4][i - j * 50];
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i - j * 100 >= 0; j++) {
                dp[6][i] += dp[5][i - j * 100];
            }
        }
        System.out.println(dp[6][n]);
    }
}