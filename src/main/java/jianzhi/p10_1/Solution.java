package jianzhi.p10_1;

import org.junit.Test;

public class Solution {
    public int fib(int n) {
        int ppre = 0;
        int pre = 1;
        if (n == 0 || n == 1) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            int temp = (pre + ppre) % 1000000007;
            ppre = pre;
            pre = temp;
        }
        return pre;
    }

    @Test
    public void test() {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(100));
    }
}
