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
    public int countNodes=0;
    public int goodNodes(TreeNode root) {
        
        if(root==null) return 0;
        count(root,root.val);
        return countNodes;
    }

    private void count(TreeNode node,int maxSoFar){
        if(node==null){
            return;
        }

        if(node.val>=maxSoFar){
            countNodes++;
        }
        int newMax=Math.max(maxSoFar,node.val);
        count(node.left,newMax);
        count(node.right,newMax);

    }
}
