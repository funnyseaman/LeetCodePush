package all.p440;

import org.junit.Test;

public class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;

        while (k > 0) {
            int nodes = getNodes(n, cur);
            if (k >= nodes) {
                k -= nodes;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    private int getNodes(int n, int cur) {
        int next = cur + 1;
        int totalNodes = 0;
        while (cur <= n) {
            totalNodes += Math.min(next - cur, n - cur + 1);
            cur *= 10;
            next *= 10;
        }
        return totalNodes;
    }

    @Test
    public void test(){
        System.out.println(findKthNumber(10,3));
    }
}
