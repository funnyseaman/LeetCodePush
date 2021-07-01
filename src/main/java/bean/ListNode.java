package bean;

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }

    public static ListNode createFromArrays(int[] values) {
        ListNode root = new ListNode();
        ListNode curr = root;
        for (int val : values) {
            ListNode temp = new ListNode(val);
            curr.next = temp;
            curr = curr.next;
        }
        return root.next;
    }

}
