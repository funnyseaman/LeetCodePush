package learning.algorithms.sort;

import util.PrettyFormat;

public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            // 寻找需要插入的位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < a[j]) {
                    // 移动数据
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 因为在找到插入位置后j自减1，这里要加回来
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.printArray(a);
        InsertionSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.printArray(a);
        InsertionSort.sort(a);
        PrettyFormat.printArray(a);

        a = new int[]{};
        PrettyFormat.printArray(a);
        InsertionSort.sort(a);
        PrettyFormat.printArray(a);

    }
}
