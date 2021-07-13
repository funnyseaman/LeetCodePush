package jianzhi.p21;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            while (low < nums.length && nums[low] % 2 == 1) {
                low++;
            }
            while (high >= 0 && nums[high] % 2 == 0) {
                high--;
            }
            if (low < high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        return nums;
    }


    @Test
    public void test() {
        System.out.println(Arrays.toString(exchange(new int[]{1, 3})));
    }
}
