package jianzhi.p11;

import org.junit.Test;

public class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

    @Test
    public void test() {
        System.out.println(minArray(new int[]{1, 3, 3}));
    }
}
