package exam;

import java.util.Scanner;

public class Main2 {
    // 1,5,10,20,50,100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i1 = 0; i1 <= n / 100; i1++) {
            int s1 = n - i1 * 100;
            for (int i2 = 0; i2 <= s1 / 50; i2++) {
                int s2 = s1 - i2 * 50;
                for (int i3 = 0; i3 <= s2 / 20; i3++) {
                    int s3 = s2 - i3 * 20;
                    for (int i4 = 0; i4 <= s3 / 10; i4++) {
                        int s4 = s3 - i4 * 10;
                        for (int i5 = 0; i5 <= s4 / 5; i5++) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
