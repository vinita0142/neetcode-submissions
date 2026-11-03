# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index={}

        for i in range(len(inorder)):
            inorder_index[inorder[i]]=i
        
        preorder_index=[0]

        def build(left,right):
            if left > right:
                return None

            root_val=preorder[preorder_index[0]]
            preorder_index[0]+=1

            root=TreeNode(root_val)

            root_index=inorder_index[root_val]
            root.left=build(left,root_index-1)
            root.right=build(root_index+1,right)
            return root
        return build(0,len(inorder)-1)
