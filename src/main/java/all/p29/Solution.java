package all.p29;


import org.junit.Test;

public class Solution {
    // 两数相除
    public int divide(int dividend, int divisor) {
        // 被除数为0
        if (dividend == 0) {
            return 0;
        }
        // 除数为1或-1
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        // 被除数为-2^32，除数为-1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int symbol = 1;
        if (dividend < 0) {
            symbol = -symbol;
        }
        if (divisor < 0) {
            symbol = -symbol;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int res = div(a, b);
        return symbol > 0 ? res : -res;
    }

    private int div(long a, long b) {
        if (a < b) {
            return 0;
        }
        int count = 1;
        long tb = b;
        while (tb + tb <= a) {
            count += count;
            tb += tb;
        }
        return count + div(a - tb, b);
    }


    @Test
    public void test() {
        System.out.println(divide(Integer.MIN_VALUE, 4));
    }
}
