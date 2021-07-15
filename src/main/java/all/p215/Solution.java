package all.p215;

import org.junit.Test;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return myFind(nums, 0, nums.length - 1, k);
    }

    private int myFind(int[] nums, int start, int end, int k) {
        int pivot = merge(nums, start, end);
        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot < k - 1) {
            return myFind(nums, pivot + 1, end, k);
        } else {
            return myFind(nums, start, pivot - 1, k);
        }
    }

    private int merge(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }


    @Test
    public void test() {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
