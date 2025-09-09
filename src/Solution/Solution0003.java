package Solution;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;

public class Solution0003 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int max=1;
        int left=0;
        int right=0;
        while(right<s.length()){
            char leftChar = charArray[left];
            char rightChar = charArray[right];
            if(right==left){
                right++;
                continue;
            }
            for (int i = left; i < right; i++) {
                if(rightChar==charArray[i]){
                    left=i+1;
                    break;
                }
            }
            max=Math.max(right-left+1,max);
            if(charArray[left]==leftChar){
                right++;
            }
        }
        return max;
    }
}
