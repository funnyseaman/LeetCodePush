package learning.algorithms.sort;


public class CountSort {
    public static void sort(int[] arr) {
        int[] countArr = initCountArr(arr);
    }

    // 初始化计数数组
    private static int[] initCountArr(int[] arr) {
        // 确定被排序数组的范围
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 初始化一个元素全为0的计数数组
        int[] countArr = new int[max + 1];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = 0;
        }
        // 开始统计每个元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        // 累加计算次数和
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        return countArr;
    }
}
