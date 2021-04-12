package learning.algorithms.sort;

import util.PrettyFormat;

public class BubbleSort {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            // （优化）记录是否存在数据交换
            boolean hasExchange = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    hasExchange = true;
                }
            }
            // 如果不存在数据交换，则说明已处于有序状态
            if (!hasExchange) {
                return;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        BubbleSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.print(a);
        BubbleSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{};
        PrettyFormat.print(a);
        BubbleSort.sort(a);
        PrettyFormat.print(a);

    }
}
