package jianzhi.p18;

import bean.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode prev=root;
        ListNode curr=head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev=curr;
            }
            curr = curr.next;
        }
        return root.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createFromArrays(new int[]{4, 5, 1, 9});
        ListNode res = deleteNode(head, 4);
        System.out.println(res);
    }
}
