# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        ans=[0]
        count=[0]
        self.inorder(root,count,k,ans)
        return ans[0]

    def inorder(self,root:Optional[TreeNode],count,k,ans):
        if root is None:
            return
        self.inorder(root.left,count,k,ans)
        count[0]+=1
        if count[0]==k:
            ans[0]=root.val
            return 
        self.inorder(root.right,count,k,ans)
