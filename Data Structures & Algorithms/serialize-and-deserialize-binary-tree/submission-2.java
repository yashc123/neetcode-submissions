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

public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();      
    }

    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return buildTree(values);
    }

    public TreeNode buildTree(String[] values){
        String str = values[index];
        index++;

        if(str.equals("N")){
            return null;
        }

        int daVal = Integer.parseInt(str);
        TreeNode root = new TreeNode(daVal);

        root.left = buildTree(values);
        root.right = buildTree(values);

        return root;
    }
}
