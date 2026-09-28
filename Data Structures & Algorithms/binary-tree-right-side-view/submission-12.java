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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();

        if(root == null){
            return finalList;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            finalList.add(queue.peekLast().val);
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode recent = queue.poll();

                if(recent.left != null){
                    queue.add(recent.left);
                }
                if(recent.right != null){
                    queue.add(recent.right);
                }
            }

        }

        return finalList;
    }
}

