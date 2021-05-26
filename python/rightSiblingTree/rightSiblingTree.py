# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def rightSiblingTree(root, sibling=None):
    # Write your code here.
	if root is None:
		return root
    rightSiblingTree(root.left, root.right)
	if root.left is not None:
		root.left.right = root.right
	right = root.right
	root.right = sibling
	rightSiblingTree(right, root.right.left if root.right is not None else None)
	return root
