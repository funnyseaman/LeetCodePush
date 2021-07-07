package jianzhi.p10_2;

import org.junit.Test;

public class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int ppre=1;
        int pre=2;
        if (n == 1 || n == 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            int sum = (pre + ppre) % 1000000007;
            ppre=pre;
            pre=sum;
        }
        return pre;
    }


    @Test
    public void test() {
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(4));
        System.out.println(numWays(100));
    }
}
