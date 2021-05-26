package dsalgo;
import java.util.ArrayList;
import java.util.List;

class TreeNode{
   int val;
   List<TreeNode> children;
   TreeNode(int val){
	   this.val=val;
	   this.children=new ArrayList<TreeNode>();
   }
    
}
public class NAryTreeMirror {
    
	public static void main(String[]args){
		TreeNode root1=new TreeNode(1);
		root1.children.add(new TreeNode(2));
		root1.children.add(new TreeNode(3));
		root1.children.add(new TreeNode(4));
		root1.children.get(0).children.add(new TreeNode(5));
		root1.children.get(0).children.add(new TreeNode(6));
		root1.children.get(1).children.add(new TreeNode(7));
		root1.children.get(1).children.add(new TreeNode(8));
		root1.children.get(1).children.add(new TreeNode(9));
		root1.children.get(2).children.add(new TreeNode(10));
		
		TreeNode root2=new TreeNode(1);
		root2.children.add(new TreeNode(4));
		root2.children.add(new TreeNode(3));
		root2.children.add(new TreeNode(2));
		root2.children.get(0).children.add(new TreeNode(10));
		root2.children.get(1).children.add(new TreeNode(9));
		root2.children.get(1).children.add(new TreeNode(8));
		root2.children.get(1).children.add(new TreeNode(7));
		root2.children.get(2).children.add(new TreeNode(6));
		root2.children.get(2).children.add(new TreeNode(5));
		
		
		System.out.println(isMirror(root1,root2));
	}
	
    public static boolean isMirror(TreeNode root1,TreeNode root2) {
       if(root1==null && root2 == null)
    	   return true;
       if(root1==null || root2==null)
    	   return false;
       if(root1.val != root2.val)
    	   return false;
       List<TreeNode> children1=root1.children;
       List<TreeNode> children2=root2.children;
       if(children1.size() != children2.size())
    	   return false;
       boolean res=true;
       for(int i=0,j=children1.size()-1;i<children1.size() && j>=0 ;i++,j--){
    	   res=isMirror(children1.get(i),children2.get(j));
    	   if(res==false)
    		   return false;
       }
       return true;
    }
    
}
