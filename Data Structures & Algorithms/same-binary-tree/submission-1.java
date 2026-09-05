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
    boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        daSame(p, q);
        return same;
    }

    private void daSame(TreeNode p, TreeNode q){
        if(!(p == null && q == null)){
            if(p == null || q == null){
                same = false;
            }
            else if(p.val == q.val){
                daSame(p.left, q.left);
                daSame(p.right, q.right);
            }
            else{
                same = false;
            }
        }
            
    }
}
