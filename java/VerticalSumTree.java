package dsalgo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int val){
	   this.val=val;
	   
   }
    
}
public class VerticalSumTree {
    /**
     * 
     * @param args
     */
	public static void main(String[]args){
		Map<Integer, Integer> map=new TreeMap<Integer, Integer>();
		
		TreeNode root=new TreeNode(13);
		root.left=new TreeNode(10);
		root.right=new TreeNode(18);
		root.left.left=new TreeNode(8);
		root.left.right=new TreeNode(12);
		root.left.right.left=new TreeNode(11);
		root.right.right=new TreeNode(20);
		root.right.right.left=new TreeNode(22);
		verticalSum(root,0,map);
		System.out.println(map.values());
	}
	
	private static void verticalSum(TreeNode root, int label, Map<Integer, Integer> map){
		if(root==null)
			return;
		if(!map.containsKey(label)){
			map.put(label, 0);
		}
		
		map.put(label, map.get(label)+root.val);
		verticalSum(root.left,label-1,map);
		verticalSum(root.right,label+1,map);
		
		
		
		
	}
}
