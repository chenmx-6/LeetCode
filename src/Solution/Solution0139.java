package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution0139
 * @Date 2025-7-16 11:07
 * @Created by ChenMX
 */
public class Solution0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] r = new boolean[s.length()+1];
        r[0]=true;
        for (int i = 0; i < s.length(); i++) {
            if(!r[i]){
                continue;
            }
            for (int j = i+1; j <= s.length(); j++) {
                if(r[i]==true&&wordDict.contains(s.substring(i, j))){
                    r[j]=true;
                }
            }
        }
        return r[s.length()];
    }

    public static void main(String[] args) {
        Solution0139 solution0139 = new Solution0139();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");
        boolean leetcode = solution0139.wordBreak("leetcode", strings);
        System.out.println(leetcode);
    }

}
