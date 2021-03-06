/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]

 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          

 

2. Now removing the leaf [2] would result in this tree:

          1          

 

3. Now removing the leaf [1] would result in the empty tree:

          []         
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        height(root, lst);
        return lst;
    }
    private int height(TreeNode node, List<List<Integer>> lst){
        if(node==null) return -1;
        int level=1+Math.max(height(node.left, lst), height(node.right, lst));
        if(lst.size()<level+1){
            lst.add(new ArrayList<Integer>());
        }
        lst.get(level).add(node.val);
        node.left=node.right=null;
        return level;
        
    }
}
