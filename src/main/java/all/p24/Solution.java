package all.p24;

import bean.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode prev = root;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return root.next;
    }


    @Test
    public void test() {
        ListNode a5 = new ListNode(5);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        System.out.println(swapPairs(a1));
    }
}
