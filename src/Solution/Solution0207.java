package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @date 2026/4/5 0:58
 */
public class Solution0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean r = dfs(lists, flags, i);
            if(!r){
                return r;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<List<Integer>> lists,int[] flags,int i){
        if(flags[i]==-1)return true;
        if(flags[i]==1)return false;
        flags[i]=1;
        List<Integer> list = lists.get(i);
        for (int j = 0; j < list.size(); j++) {
            boolean dfs = dfs(lists, flags, list.get(j));
            if(!dfs)return dfs;
        }
        flags[i]=-1;
        return true;
    }
}
