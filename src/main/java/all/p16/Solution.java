package all.p16;

import org.junit.Test;

import java.util.Arrays;

/*
    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int best = 1000000;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            /*
                sum表示三数之和
                1）sum==target: 因为只存在唯一答案，所以已找到最接近的值
                2）sum<target:  需要增大b的值，所以把左指针向右移动
                3）sum>target:  需要减小c的值，所以把右指针向左移动
                注意：若未找到相等值，则需要更新最接近的值

                优化点：
                移动左右指针时，如果和上一个数相同，则继续移动
             */
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
                if (sum > target) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return best;
    }


    @Test
    public void test() {
//        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
