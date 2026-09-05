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
    
    boolean subTree = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        subSearch(root, subRoot);
        return subTree;
    }

    private void subSearch(TreeNode root, TreeNode subRoot){
        if(root != null){
            if(root.val == subRoot.val){
                if(verify(root, subRoot)){
                    subTree = true;
                }
                else{
                subSearch(root.left, subRoot);
                subSearch(root.right, subRoot);
                }
            }
            else{
            subSearch(root.left, subRoot);
            subSearch(root.right, subRoot);
            }
        }
    }

    private boolean verify(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val){
            return verify(root.left, subRoot.left) && verify(root.right, subRoot.right);
        }
        else{
            return false;
        }
    }
}
