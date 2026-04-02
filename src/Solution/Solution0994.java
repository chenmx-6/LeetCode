package Solution;

import java.util.ArrayList;

/**
 * @author chenmx
 * @date 2026-4-1
 **/

public class Solution0994 {
    public int orangesRotting(int[][] grid) {
        boolean rot=true;
        int res=0;
        while(rot){
            rot=false;
            ArrayList<int[]> q = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j]==2)q.add(new int[]{i,j});
                }
            }
            for (int i = 0; i < q.size(); i++) {
                int[] ints = q.get(i);
                boolean mark = mark(grid, ints[0], ints[1]);
                if(mark){
                    rot=true;
                }
            }
            if(rot){
                res++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }

    public boolean mark(int[][] grid,int i,int j){
        if(grid[i][j]!=2)return false;
        boolean rot=false;
        if(i>=1&&grid[i-1][j]==1){
            rot=true;
            grid[i-1][j]=2;
        }
        if(j>=1&&grid[i][j-1]==1){
            rot=true;
            grid[i][j-1]=2;
        }
        if(j<grid[0].length-1&&grid[i][j+1]==1){
            rot=true;
            grid[i][j+1]=2;
        }
        if(i<grid.length-1&&grid[i+1][j]==1){
            rot=true;
            grid[i+1][j]=2;
        }
        return rot;
    }

    public static void main(String[] args) {
        Solution0994 solution0994 = new Solution0994();
        int[][] ints={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution0994.orangesRotting(ints));
    }
}
