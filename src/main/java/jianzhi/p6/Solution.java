package jianzhi.p6;

import bean.ListNode;

import java.util.Stack;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode curr = head;
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (curr != null) {
            stack.push(curr.val);
            len++;
            curr = curr.next;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
