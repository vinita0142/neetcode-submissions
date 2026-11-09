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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> res=new ArrayList<>();
        dfs(root,res);
        return String.join(",",res);
    
    }


    private void dfs(TreeNode node,List<String> res){
        if(node==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfs(node.left,res);
        dfs(node.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values=data.split(",");
        int[] index={0};

        return dfsd(values,index);
    }

    private TreeNode dfsd(String[] values, int[] index){
        if(values[index[0]].equals("N")){
            index[0]++;
            return null;
        }

        TreeNode node=new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left=dfsd(values,index);
        node.right=dfsd(values,index);
        return node;

    }

}
