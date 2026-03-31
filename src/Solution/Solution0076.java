package Solution;

/**
 * @author chenmx
 * @date 2026-3-30
 **/

public class Solution0076 {

    public String minWindow(String s, String t) {
        //s = "ADOBECODEBANC", t = "ABC"
        int left=0;
        int right=0;
        int[] tList = new int[52];
        int[] sList = new int[52];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tList[c-'a']++;
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if(t.contains(c)){
                sList[c-'a']++;
            }
        }

    }
}
