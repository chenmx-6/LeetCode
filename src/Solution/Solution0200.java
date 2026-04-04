package Solution;

/**
 * @author chenmx
 * @date 2026-4-1
 **/

public class Solution0200 {
    public int numIslands(char[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if('1'==grid[i][j]){
                    res++;
                    mark(grid,i,j);
                }
            }
        }
        return res;
    }

    public void mark(char[][] grid, int i,int j){
        if(i<0||i>=grid.length){
            return;
        }
        if(j<0||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            mark(grid,i-1,j);
            mark(grid,i,j-1);
            mark(grid,i+1,j);
            mark(grid,i,j+1);
        }
    }

}
