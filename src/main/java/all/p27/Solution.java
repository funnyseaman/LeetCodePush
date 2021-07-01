package all.p27;

import org.junit.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] nums=new int[]{3,2,2,3,1};
        System.out.println(removeElement(nums,3));

        System.out.println();
    }
}
