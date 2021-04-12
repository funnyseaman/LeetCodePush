package learning.algorithms.sort;

import util.PrettyFormat;

public class InsertionSort {
    public static void sort(int[] a) {
        int[] res;
        for (int i = 0; i < a.length; i++) {

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 2, 7, 3, 5, 8, 1, 3};
        PrettyFormat.print(a);
        InsertionSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{1, 5, 3, 7, 9};
        PrettyFormat.print(a);
        InsertionSort.sort(a);
        PrettyFormat.print(a);

        a = new int[]{};
        PrettyFormat.print(a);
        InsertionSort.sort(a);
        PrettyFormat.print(a);

    }
}
