/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private TreeNode sub;
    private int target;
    private boolean found;


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        sub = subRoot;
        target = height(sub);
        found = false;
        check(root);
        return found;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private int check(TreeNode root){
        if(root == null){
            return 0;
        }

        int h = 1 + Math.max(check(root.left), check(root.right));

        if(h == target && isSameTree(root, sub)){
            found = true;
        }

        return h;
    }


 

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

