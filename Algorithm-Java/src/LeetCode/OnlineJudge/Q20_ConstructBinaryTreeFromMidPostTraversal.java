/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q20_ConstructBinaryTreeFromMidPostTraversal {

    public BinaryTreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return buildTreeHelper(0, length - 1, 0, length - 1, inorder, postorder);
    }

    private BinaryTreeNode<Integer> buildTreeHelper(int post_s, int post_e, int in_s, int in_e, int[] inorder, int[] postorder) {
        if (in_s > in_e) {
            return null;
        }
        int root_val = postorder[post_e];
        int i = in_s;
        for (i = in_s; i <= in_e; ++i) {
            if (inorder[i] == root_val) {
                break;
            }
        }
        int left_len = i - in_s;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(root_val);
        root.Left = buildTreeHelper(post_s, post_s + left_len - 1, in_s, i - 1, inorder, postorder);
        root.Right = buildTreeHelper(post_s + left_len, post_e - 1, i + 1, in_e, inorder, postorder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {2, 5, 7, 10, 15};
        int[] postorder = {2, 7, 5, 15, 10};
        BinaryTreeNode<Integer> root = new Q20_ConstructBinaryTreeFromMidPostTraversal().buildTreeMy(inorder, postorder);
        System.out.print(root);
    }

    //my way
    public BinaryTreeNode<Integer> buildTreeMy(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return buildTreeHelperMy(0, length - 1, 0, length - 1, inorder, postorder);
    }

    private BinaryTreeNode<Integer> buildTreeHelperMy(int post_s, int post_e, int in_s, int in_e, int[] inorder, int[] postorder) {
        if (in_s > in_e || post_e < 0 || post_e >= inorder.length) {
            return null;
        }
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(postorder[post_e]);
        int len = 0;
        for (int i =   in_s; i <= in_e; i++) {
            if (inorder[i] == postorder[post_e]) {
                break;
            }
            ++len;
        }
        node.Left = buildTreeHelperMy(post_s, post_s + len - 1, in_s, in_s + len - 1, inorder, postorder);
        node.Right = buildTreeHelperMy(post_s + len, post_e - 1, in_s + len + 1, in_e, inorder, postorder);
        return node;
    }
}
