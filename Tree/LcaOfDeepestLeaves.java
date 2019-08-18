import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
    The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.

https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

Find the deepest leaves, then find their lca 

**/


// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
}
class LcaOfDeepestLeaves {
    /**
     * 
     * @param root
     * @return lowest common ancestors of deepest leaves
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currQueueSize=1;
        Set<TreeNode> leaves= new HashSet<TreeNode>();
        while(currQueueSize>0){
            TreeNode tmp=queue.remove();
            currQueueSize--;
            leaves.add(tmp);
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!= null){
                queue.add(tmp.right);
            }
            if(currQueueSize==0){
                currQueueSize=queue.size();
                if(currQueueSize>0){
                    leaves = new HashSet<TreeNode>();
                }
            }
        }
        return findLca(root,leaves);
      
    }
    /**
     * 
     * @param root
     * @param nodes
     * @return find lca of the nodes provided
     */
    private TreeNode findLca(TreeNode root, Set<TreeNode> nodes){
        if(root==null)
            return null;
        if(nodes.contains(root)){
            return root;
        }
        TreeNode left = findLca(root.left, nodes);
        TreeNode right = findLca(root.right, nodes);
        if(left!= null && right != null){
            return root;
        }
        
        return left!=null?left:right;
    }
}
