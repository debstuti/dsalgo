package dsalgo;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author debstutidas
 *
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode point;
	TreeNode(int val){
		this.val=val;
	}
}
class SetLevelPointer {
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(10);
		root.left.left.left=new TreeNode(8);
		root.right.right=new TreeNode(7);
		root.right.right.right=new TreeNode(15);
		root.left.left.left.right=new TreeNode(16);
		root.right.right.right.left=new TreeNode(31);
		setPointer(root);
		TreeNode node =root;
		while(node !=null){
			System.out.print(node.val+" ");
			TreeNode tmp=node;
			while(node.point !=null){
				System.out.print(node.point.val+" ");
				node=node.point;
			}
			node=tmp.left;
			if(node ==null)
				node=tmp.right;
			System.out.println();
		}
	}
	public static TreeNode setPointer(TreeNode root){
		if(root==null)
			return root;
		
		if(root.left !=null){
			
			if(root.right !=null){
				root.left.point=root.right;
			}else if(root.point !=null){
				if(root.point.left != null)
					root.left.point=root.point.left;
				else if(root.point.right !=null)
					root.left.point=root.point.right;
			}
		}
		if(root.right != null){
			if(root.point !=null){
				if(root.point.left != null)
					root.right.point=root.point.left;
				else if(root.point.right !=null)
					root.right.point=root.point.right;
			}
		}
		root.left=setPointer(root.left);
		root.right=setPointer(root.right);
		return root;
	}
	
}
