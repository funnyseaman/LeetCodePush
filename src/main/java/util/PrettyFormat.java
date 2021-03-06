package util;

/**
 * Author: Sinan Fan
 */
public class PrettyFormat {
    /**
     * pretty format printing
     *
     * @param a array
     */
    public static <T> void printArray(T[] a) {
        StringBuilder sb = new StringBuilder("[");
        if (a.length > 0) {
            for (T i : a) {
                sb.append(i);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        if (a.length > 0) {
            for (int i : a) {
                sb.append(i);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }
}
