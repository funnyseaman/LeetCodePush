package learning.algorithms.search;

import org.junit.Test;

public class BinarySearch {
    // 原式：最简单的二分查找
    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    // 变式1：二分查找目标值的左侧边界
    public static int searchFirst(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] == value) {
                // 若mid是数组第一个数时，表示找到了左边界
                // 若mid前一个数不是目标值，表示找到了左边界
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                }
                // 若不满足条件，则左边界在[low,mid-1]区间
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    // 变式2：二分查找目标值的右侧边界
    public static int searchLast(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] == value) {
                // 若mid是数组最后一个数时，表示找到了右边界
                // 若mid后一个数不是目标值，表示找到了右边界
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                }
                // 若不满足条件，则左边界在[mid+1,high]区间
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    // 变式3：查找第一个大于等于目标值的元素
    public static int searchFirstGreaterOrEqual(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] >= value) {
                // 若mid是数组第一个数时，表示找到了第一个大于等于目标值的元素
                // 若mid前一个数小于目标值，表示找到了第一个大于等于目标值的元素
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                }
                // 若不满足条件，则第一个大于等于目标值的元素在[low,mid-1]区间
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    // 变式4：查找最后一个小于等于目标值的元素
    public static int searchLastLessOrEqual(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] <= value) {
                // 若mid是数组最后一个数时，表示找到了最后一个小于等于目标值的元素
                // 若mid后一个数大于目标值，表示找到了最后一个小于等于目标值的元素
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                }
                // 若不满足条件，则最后一个小于等于目标值的元素在[mid+1,high]区间
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void testSearch() {
        int[] arr = new int[]{2, 4, 5, 7, 12, 13};
        System.out.println(BinarySearch.search(arr, 7));
        System.out.println(BinarySearch.search(arr, 2));
        System.out.println(BinarySearch.search(arr, 13));
        System.out.println(BinarySearch.search(arr, 10));
    }

    @Test
    public void testSearchFirst() {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(BinarySearch.searchFirst(arr, 8));
        System.out.println(BinarySearch.searchFirst(arr, 1));
    }

    @Test
    public void testSearchLast() {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 8, 11, 18};
        System.out.println(BinarySearch.searchLast(arr, 8));
        System.out.println(BinarySearch.searchLast(arr, 18));
    }

    @Test
    public void testSearchFirstGreaterOrEqual() {
        int[] arr = new int[]{2, 4, 5, 7, 12, 13};
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 4));
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 6));
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 1));
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 2));
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 13));
        System.out.println(BinarySearch.searchFirstGreaterOrEqual(arr, 14));
    }

    @Test
    public void testSearchLastLessOrEqual() {
        int[] arr = new int[]{2, 4, 5, 7, 12, 13};
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 4));
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 6));
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 1));
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 2));
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 13));
        System.out.println(BinarySearch.searchLastLessOrEqual(arr, 14));
    }
}
