package jianzhi.p24;

import bean.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode head1 = ListNode.createFromArrays(new int[]{1, 2, 3, 4});
        ListNode head2 = ListNode.createFromArrays(new int[]{});
        System.out.println(reverseList(head1));
        System.out.println(reverseList(head2));
    }
}
