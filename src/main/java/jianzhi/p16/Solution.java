package jianzhi.p16;

import org.junit.Test;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if (x == 0) {
            return 0;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
    }
}
