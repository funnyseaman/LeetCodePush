package jianzhi.p17;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(Arrays.toString(printNumbers(1)));
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}
