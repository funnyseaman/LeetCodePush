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
        int[] nums=new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(findKthLargest(nums, 24));
    }
}
