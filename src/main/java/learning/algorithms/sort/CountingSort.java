package learning.algorithms.sort;


import org.junit.Test;
import util.PrettyFormat;

public class CountingSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        // 初始化计数数组
        int[] countArr = initCountArr(arr);
        // 临时数组，存储排序后结果
        int[] tempArr = new int[arr.length];
        // 从尾遍历原数组，根据计数数组，将遍历元素放入临时数组中排序后位置
        for (int i = arr.length - 1; i >= 0; i--) {
            tempArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }
        // 临时数组覆盖原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tempArr[i];
        }
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


    @Test
    public void testSort() {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.printArray(a);
        CountingSort.sort(a);
        PrettyFormat.printArray(a);
        System.out.println();

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.printArray(a);
        CountingSort.sort(a);
        PrettyFormat.printArray(a);
        System.out.println();

        a = new int[]{1};
        PrettyFormat.printArray(a);
        CountingSort.sort(a);
        PrettyFormat.printArray(a);
        System.out.println();

        a = new int[]{};
        PrettyFormat.printArray(a);
        CountingSort.sort(a);
        PrettyFormat.printArray(a);
    }

}
