package Solution;

/**
 * @Classname Solution0005
 * @Date 2025-7-16 15:22
 * @Created by ChenMX
 */
public class Solution0005 {

    public String longestPalindrome(String s) {
        int max=1;
        String maxStr=s.substring(0,1);
        int length = s.length();
        boolean[][] r = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            r[i][i]=true;
        }
        char[] charArray = s.toCharArray();
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l - 1;
                if(j>=length){
                    break;
                }
                if(j-i==1){
                    if(charArray[i]==charArray[j]){
                        r[i][j]=true;
                    }
                }else{
                    if(charArray[i]==charArray[j]){
                        if(r[i+1][j-1]){
                            r[i][j]=true;
                        }
                    }

                }
                if(r[i][j]){
                    max = Integer.max(j - i, max);
                    maxStr=s.substring(i,j+1);
                }
            }
        }
        return maxStr;
    }



    public String longestPalindrome2(String s) {
        char[] charArray = s.toCharArray();
        String maxString=s.substring(0,1);
        int length = s.length();
        boolean[][] r = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            r[i][i]=true;
        }
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j=i+l-1;
                if(j>=length){
                    break;
                }
                if(charArray[i]==charArray[j]){
                    if(l==2){
                        r[i][j]=true;
                    }else{
                        if(r[i+1][j-1]){
                            r[i][j]=true;
                        }
                    }
                }
                if(r[i][j]){
                    maxString=s.substring(i,j+1);
                }
            }
        }
        return maxString;
    }
}
