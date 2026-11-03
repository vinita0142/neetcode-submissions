# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        result=[]

        def preorder(node):
            if node is None:
                result.append("None")
                return
            result.append(str(node.val))
            preorder(node.left)
            preorder(node.right)
        preorder(root)
        return ",".join(result)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        values=data.split(",")
        index=[0]

        def build():
            if values[index[0]]=="None":
                index[0]+=1
                return None
            node = TreeNode(int(values[index[0]]))

            index[0]+=1
            node.left=build()
            node.right=build()
            return node
        return build()