package learning.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {

    // 堆排序分为两步：建堆、排序
    public static void sort(int[] arr) {
        // 构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从最后一个非叶子节点开始调整
            heapify(arr, i, arr.length);
        }
        // 调整堆结构，交换堆顶元素和末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            heapify(arr, 0, j);
        }
    }

    // 堆化，采用自顶向下的方法，即下沉
    private static void heapify(int[] arr, int i, int length) {
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点，子节点和父节点互换
            if (arr[k] > arr[i]) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @Test
    public void test() {
        int[] arr = {2, 3, 6, 8, 5, 2, 5, 7, 3, 7, 9, 5, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
