package jianzhi.p7;

import bean.TreeNode;
import org.junit.Test;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int right = preorder.length - 1;
        return buildTreeRecursion(preorder, 0, right, inorder, 0, right);
    }

    private TreeNode buildTreeRecursion(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR || preL >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        // 查找前序遍历中第一个元素在中序遍历中的位置
        int index;
        for (index = inL; index <= inR; index++) {
            if (inorder[index] == preorder[preL]) {
                break;
            }
        }
        root.left = buildTreeRecursion(preorder, preL + 1, preL + (index - inL), inorder, 0, index - 1);
        root.right = buildTreeRecursion(preorder, index + 1, preR, inorder, index + 1, inR);
        return root;
    }

    @Test
    public void test() {
//        TreeNode root = buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        root.toLevelString();
    }
}
