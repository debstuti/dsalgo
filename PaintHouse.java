/*There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.*/
             
             
class Solution {
    public int minCost(int[][] costs) {
        Map<String, Integer> memo= new HashMap<>();
        return Math.min(helper(costs,0,0, memo), Math.min(helper(costs,0,1,memo),helper(costs,0,2,memo)));
    }
    private int helper(int[][] costs, int h, int color, Map<String, Integer> memo){
        if(h==costs.length){
            return 0;
        }
        if(memo.containsKey(h+" "+color)){
            return memo.get(h+" "+color);
        }
        int result=costs[h][color];
        if(color==0){
            result+=Math.min(helper(costs,h+1,1,memo), helper(costs, h+1,2,memo));
        }else if(color==1){
            result+=Math.min(helper(costs,h+1,0,memo), helper(costs, h+1,2,memo));
        }else if(color==2){
            result+=Math.min(helper(costs,h+1,0,memo), helper(costs, h+1,1,memo));
        }
        memo.put(h+" "+color,result);
        return result;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*


    Time complexity : O(n)O(n)O(n).

    Analyzing memoization algorithms can be tricky at first, and requires understanding how recursion impacts the cost differently to loops. The key thing to notice is that the full function runs once for each possible set of parameters. There are 3 * n different possible sets of parameters, because there are n houses and 3 colors. Because the function body is O(1)O(1)O(1) (it's simply a conditional), this gives us a total of 3 * n. There can't be more than 3 * 2 * n searches into the memoization dictionary either. The tree showed this clearly—the nodes representing lookups had to be the child of a call where a full calculation was done. Because the constants are all dropped, this leaves O(n)O(n)O(n).

    Space complexity : O(n)O(n)O(n).

    Like the previous approach, the main space usage is on the stack. When we go down the first branch of function calls (see the tree visualization), we won't find any results in the dictionary. Therefore, every house will make a stack frame. Because there are n houses, this gives a worst case space usage of O(n)O(n)O(n). Note that this could be a problem in languages such as Python, where stack frames are large.

*/


/*
bottom up dp without extra space */

class Solution {
    public int minCost(int[][] costs) {
      if(costs.length==0 || costs[0].length==0) return 0;
      int m=costs[0].length;
      for(int i=costs.length-2;i>=0;i--){
          for(int j=0;j<m;j++){
              costs[i][j]=costs[i][j]+getMin(costs,i+1,j);
          }
      }
      return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
    private int getMin(int[][] costs, int row, int colToSkip){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<costs[0].length;i++){
            if(i==colToSkip) continue;
            min=Math.min(min, costs[row][i]);
        }
        return min;
    }
   
}

/*


    Time Complexity : O(n)O(n)O(n).

    Same as previous approach.

    Space Complexity : O(1)O(1)O(1)

    We're "remembering" up to 666 calculations at a time (using 2 x length-3 arrays). Because this is actually a constant, the space complexity is still O(1)O(1)O(1).

    Like the time complexity though, this analysis is dependent on there being a constant number of colors (i.e. 3). If the problem was changed to be mmm colors, then the space complexity would become O(m)O(m)O(m) as we'd need to keep track of a couple of length-m arrays.


*/

