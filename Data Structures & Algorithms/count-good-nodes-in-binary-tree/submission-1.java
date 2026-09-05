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
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        findGood(root, root.val);

        return goodNodes;
    }

    private void findGood(TreeNode root, int max){
        if(root != null){
            if(max <= root.val){
                goodNodes++;
            }

            findGood(root.left, Math.max(max, root.val));
            findGood(root.right, Math.max(max, root.val));
        }
    }
}
