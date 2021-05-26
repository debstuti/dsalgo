package dsalgo;
/**

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]


https://leetcode.com/problems/max-area-of-island/
**/



class MaxAreaOfIsland {
    static int count =0;
    /**
     * 
     * @param grid
     * @return max island size
     */
    public int maxAreaOfIsland(int[][] grid) {
       
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    count=0;
                    process(i,j,grid);
                    if(count>max)
                        max=count;
                }
            }
        }
        return max;
    }
    
    /**
     * 
     * @param i
     * @param j
     * @param grid
     */
    private void process(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length)
            return;
        if(j<0 || j>=grid[0].length)
            return;
        if(grid[i][j] != 1) // no need to consider if grid value =0 or value=-1
            return;
        grid[i][j]=-1; // -1 for marking the node visited
        count++;
        process(i+1,j,grid);  // process 4-firectionallu
        process(i-1,j,grid);
        process(i,j-1,grid);
        process(i,j+1,grid);
    
    }
}
