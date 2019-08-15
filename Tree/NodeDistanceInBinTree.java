import java.util.*;

/**
 * TreeNode - the structure of a tree Node
 */
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    int label;
    TreeNode(char val){
        this.val = val;
        this.left=this.right=null;
        this.label =0;
    }
}
public class NodeDistanceInBinTree {
    /**
     * creates a dummy binary tree and calculates the distance between any two nodes
     * @param args
     */
    public static void main(String[] args){
        TreeNode root =new TreeNode('a');
        root.left=new TreeNode('b');
        root.right=new TreeNode('c');
        root.left.left=new TreeNode('d');
        root.left.right=new TreeNode('e');
        int dist = findDistance(root,'d','e');
        System.out.println(dist);

        dist = findDistance(root,'d','c');
        System.out.println(dist);
    }

    /**
     *
     * @param root - root of the binary tree
     * @param c1 - first char from which distance to be calculated
     * @param c2 - second char to which distance ti be calculated
     * @return - calculates and returns the distance between c1 and c2 as - c1.label+c2.label-2*lca.label
     */
    public static int findDistance(TreeNode root, char c1, char c2){
        List<Integer> labels = new ArrayList<Integer>();
        TreeNode lca = findlca(root,c1,c2,0,labels);
        System.out.println("root ="+root.label+" lca="+lca.val+"+ lca.label="+lca.label+" labels of c1 & c2= "+labels);
        int distance = labels.get(0)+labels.get(1)-2*lca.label;
        return distance;
    }

    /**
     *
     *
     * @param root - root of the binary tree
     * @param c1 - first char from which distance to be calculated
     * @param c2 - second char to which distance ti be calculated
     * @param label -label of current root, while recusring
     * @param labels - a list which stores the labels of c1 and c2
     * @return -label of lca in label , and in labels we store the labels of c1 and c2
     */
    public  static TreeNode findlca(TreeNode root, char c1, char c2, int label, List<Integer> labels){
        if(root == null)
            return null;
        root.label=label;
        if(root.val==c1 || root.val ==c2) {
            labels.add(label);
            return root;
        }
        TreeNode left = findlca(root.left,c1,c2,label+1,labels);
        TreeNode right = findlca(root.right,c1,c2,label+1,labels);
        if(left !=null && right !=null){
            return root;
        }
        return left!=null?left:right;
    }


}
