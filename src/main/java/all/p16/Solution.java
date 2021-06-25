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
        int res = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int need = target - nums[i];
            /*
                need表示目标值与第一个数的差，b和c分别表示后两个数
                1）b+c==need: 因为只存在唯一答案，所以已找到最接近的值
                2）b+c<need:  需要增大b的值，所以
                3）b+c>need:  需要减小c的值，所以
             */
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (b + c == need) {
                    return target;
                } else if (b + c < need) {

                } else if (b + c > need) {

                }
            }
        }


        return res;
    }


    @Test
    public void test() {

    }
}
