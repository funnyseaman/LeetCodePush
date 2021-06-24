package all.p4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        double median;

        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            median = findKthValue(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            double k1 = findKthValue(nums1, nums2, midIndex1 + 1);
            double k2 = findKthValue(nums1, nums2, midIndex2 + 1);
            median = (k1 + k2) / 2;
        }

        return median;
    }


    public double findKthValue(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 如果nums1都被排除了，那么剩余的nums2中第K个数就是中间数
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 同理，如果nums2都被排除了，那么剩余的nums1中第K个数就是中间数
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            // 如果k等于1，说明只要在剩余的num1和num2的第一个元素中取最小值即可
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 需要避免越界的情况，出现越界时，选取数组最后一个元素
            int newIndex1 = Math.min(index1 + k / 2, length1) - 1;
            int newIndex2 = Math.min(index2 + k / 2, length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] num1 = {1};
        int[] num2 = {2, 3, 4, 5, 6};
        Solution so = new Solution();
        double result = so.findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }

}
