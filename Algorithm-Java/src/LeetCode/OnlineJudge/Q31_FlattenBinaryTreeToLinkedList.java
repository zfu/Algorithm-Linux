/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import Util.BinaryTreeNode;

public class Q31_FlattenBinaryTreeToLinkedList {

    BinaryTreeNode<Integer> LastNode = null;

    public void flatten(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> left = root.Left;
        BinaryTreeNode<Integer> right = root.Right;
        if (LastNode != null) {
            LastNode.Right = root;
            root.Right = null;
        }
        root.Left = null;
        LastNode = root;
        flatten(left);
        flatten(right);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.getSampleTree();
        new Q31_FlattenBinaryTreeToLinkedList().flattenMy(root);
    }
    BinaryTreeNode<Integer> LastNodeMy = null;

    public void flattenMy(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        flattenMy(root.Left);
        if (LastNodeMy != null) {
            LastNodeMy.Right = root;
            root.Parent = LastNodeMy;
        }
        root.Left =null;
        LastNodeMy = root;
        
        flatten(root.Right);
    }
}
