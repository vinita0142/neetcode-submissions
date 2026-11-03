# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum=[float("-inf")]

        def gain(node):
            if node is None:
                return 0
            left_gain=max(0,gain(node.left))
            right_gain=max(0,gain(node.right))

            current_path=left_gain+node.val+right_gain
            max_sum[0]=max(max_sum[0],current_path)

            return node.val+max(left_gain,right_gain)
        gain(root)
        return max_sum[0]