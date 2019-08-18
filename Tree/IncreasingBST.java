
/**
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
https://leetcode.com/problems/increasing-order-search-tree/

**/

 // Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class IncreasingBST {
    
    TreeNode tmp;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans= new TreeNode(0);
        tmp=ans;
        helper(root);
        return ans.right;
    }
    private void helper(TreeNode root){
        if(root==null)
            return;
        
        helper(root.left);
        
        tmp.right=root;
        
        tmp=tmp.right;
        tmp.left=null;
        if(tmp==null)
            return;    
        helper(root.right);
    }
}
