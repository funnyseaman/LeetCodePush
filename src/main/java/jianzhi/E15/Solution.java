package jianzhi.E15;

import org.junit.Test;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String bs = Integer.toBinaryString(n);
        int count = 0;
        for (char c : bs.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(9));
    }
}
