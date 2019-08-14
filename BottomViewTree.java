import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    int label;
    TreeNode(int val){
        this.val = val;
        this.left=this.right=null;
        this.label =0;
    }
}

/**
 * A mapping class which stores node values for a particular label and height
 */
class NodeMap{
    List<Integer> nodes;
    int height;
    int label;
    NodeMap(int height,int label){
        nodes=new ArrayList<Integer>();
        this.height=height;
        this.label=label;
    }
    @Override
    public String toString(){
        return  nodes.toString();
    }
}
public class BottomViewTree {

    /**
     *
     * @param root
     * @return List<Integer> - bottom view of trees nodes
     */
    public static List<Integer>  printBottomView(TreeNode root){
        List<Integer> ans =new ArrayList<>();
        Map<Integer, NodeMap> map = new TreeMap<Integer, NodeMap>();
        printBottomViewHelper(root,0,0, map);

        //System.out.println(map.values());
        for(NodeMap nodeMap:map.values()){
            ans.addAll(nodeMap.nodes);
        }
        //System.out.println(ans);
        return ans;
    }

    /**
     *
     * @param root - root of the tree with label =0, height=0
     * @param label - label decreases when we go to left child, and increases when we go to right child
     * @param height - height /depth or the nodes, calculated recursively
     * @param map -- a treeMap with key=label, value=NodeMap. NodeMap object contains node values with particular label and max height
     */
    public static void printBottomViewHelper(TreeNode root, int label, int height, Map<Integer,NodeMap>  map){
        if(root==null)
            return;
        if(!map.containsKey(label))
            map.put(label, new NodeMap(height, label));
        NodeMap nodeMap = map.get(label);
        if(nodeMap.height<height){ // if the current nodeMap has height less than latest nodes height then latest node will hide the
                                      //  current nodeMap nodes
            map.put(label,new NodeMap(height,label));
        }
        map.get(label).nodes.add(root.val); //add the latest nodes val

        printBottomViewHelper(root.left,label-1, height+1,map);
        printBottomViewHelper(root.right,label+1, height+1,map);

    }
    public static void main(String[] args){

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        List<Integer> ans = printBottomView(root);
        System.out.println(ans);

    }
}
