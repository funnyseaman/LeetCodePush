package all.p25;

import bean.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution2 {
    /*
        每次K个节点翻转的步骤：
        1）记录起始节点startNode和起始节点前一个节点prevNode，向后数k个节点记为endNode
        2）翻转[startNode,endNode]
        3）将反转后的链表连入原链表中，并更新指针
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode root = new ListNode(0, head);

        ListNode prev = root;
        ListNode curr = head;
        ListNode endNode = findEndNode(curr, k);
        while (endNode != null) {
            ListNode nextNode = endNode.next;
            ListNode[] nodes = reverse(curr, endNode);
            // 将反转后的链表连入原链表中
            prev.next = nodes[0];
            prev = nodes[1];
            prev.next = nextNode;
            curr = nextNode;
            // 重新计算endNode
            endNode = findEndNode(curr, k);
        }
        return root.next;
    }

    // [1,2,3,4],k=3 -> [3]
    private ListNode findEndNode(ListNode node, int k) {
        ListNode endNode = node;
        k--;
        while (k > 0) {
            if (endNode != null) {
                endNode = endNode.next;
                k--;
            } else {
                return null;
            }
        }
        return endNode;
    }

    private ListNode[] reverse(ListNode startNode, ListNode endNode) {
        ListNode prev = null;
        ListNode curr = startNode;
        while (prev != endNode) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return new ListNode[]{endNode, startNode};
    }


    @Test
    public void test() {
        ListNode head1 = ListNode.createFromArrays(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseKGroup(head1, 5));
    }
}
