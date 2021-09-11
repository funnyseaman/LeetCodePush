package exam;

import java.util.Scanner;

public class Main32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            return;
        }
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int i0=0;
        int i1=0;
        int i2=0;
        for (int num : nums) {
            if(num==0){
                i0++;
            }else if(num==1){
                i1++;
            }else if(num==2){
                i2++;
            }
        }
        int[] res=new int[n];
        int cur=0;
        while (cur<n){
            if(cur<i0){
                res[cur]=0;
            }else if(cur-i0<i1){
                res[cur]=1;
            }else{
                res[cur]=2;
            }
            cur++;
        }
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
