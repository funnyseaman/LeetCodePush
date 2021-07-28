package all.p912;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    private int[] assitArr;

    public int[] sortArray(int[] nums) {
        assitArr = new int[nums.length];
        mySort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mySort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mySort(nums, start, mid);
        mySort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        if (end + 1 - start >= 0) {
            System.arraycopy(nums, start, assitArr, start, end + 1 - start);
        }
        int curr = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (assitArr[left] <= assitArr[right]) {
                nums[curr] = assitArr[left];
                left++;
            } else {
                nums[curr] = assitArr[right];
                right++;
            }
            curr++;
        }
        if (left <= mid) {
            for (; left <= mid; left++) {
                nums[curr] = assitArr[left];
                curr++;
            }
        }
        if (right <= end) {
            for (; right <= end; right++) {
                nums[curr] = assitArr[right];
                curr++;
            }
        }
    }


    @Test
    public void test() {
        int[] nums = {2, 5, 3, 7, 8, 4, 3, 7, 0, 9};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
