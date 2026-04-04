package Solution;

/**
 * @author chenmx
 * @date 2026-3-30
 **/

public class Solution0076 {

    public String minWindow(String s, String t) {
        //s = "ADOBECODEBANC", t = "ABC"
        int left=0;
        int right=-1;
        int maxLeft=0;
        int maxRight=-1;
        int r=Integer.MAX_VALUE;
        int[] tList = new int[58];
        int[] sList = new int[58];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tList[c-'A']++;
        }
        while(right<s.length()&&left<s.length()){
            boolean contains=true;
            for (int i = 0; i < 58; i++) {
                if(sList[i]<tList[i]){
                   contains=false;
                   break;
                }
            }
            if(contains){
                if(right-left+1<r){
                    maxRight=right;
                    maxLeft=left;
                    r=Integer.min(r,right-left+1);
                }
                char l = s.charAt(left);
                left++;
                if(t.contains(String.valueOf(l))){
                    sList[l-'A']--;
                }
            }else {
                right++;
                if(right<s.length()){
                    char c = s.charAt(right);
                    if(t.contains(String.valueOf(c))){
                        sList[c-'A']++;
                    }
                }
            }
        }
        return s.substring(maxLeft,maxRight+1);

    }


    public static void main(String[] args) {
        System.out.println('w'-'A');
        String s = "gehzduwqkzuyotckqcusdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiesscmigicfzn",
                t = "qsvczwsslkhwg";
        //"wqkzuyotckqcusdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiess"
        //sdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiess
        Solution0076 solution0076 = new Solution0076();
        String s1 = solution0076.minWindow(s, t);
        System.out.println(s1);
    }
}
