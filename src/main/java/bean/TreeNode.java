package bean;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void toLevelString() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                System.out.print(temp.val + ",");
                if (temp.left != null || temp.right != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            } else {
                System.out.print("null,");
            }
        }
    }
}
