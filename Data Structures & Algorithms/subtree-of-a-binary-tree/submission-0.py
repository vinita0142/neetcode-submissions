# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if subRoot is None:
            return true
        if root is None:
            return False
        
        if self.isSameTree(root,subRoot):
            return True
        if self.isSubtree(root.left,subRoot):
            return True

        return self.isSubtree(root.right,subRoot)
    
    def isSameTree(self,p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        
        return p.val==q.val and self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)
