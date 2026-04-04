package hw;

import java.util.ArrayList;
import java.util.HashMap;

public class HwTest5 {
    /**
     * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
     * 示例：
     * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
     * 输出： "dog
     * walker"
     * 解释： "dogwalker"可由"dog"和"walker"组成。
     */
    public void findLongest(){
        String[] strs= {"cat","banana","dog","nana","walk","walker","dogwalker"};
        int maxLength=0;
        String maxString="";
        int length = strs.length;
        int[][] ints = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length ; j++) {
                if(strs[i].contains(strs[j])){
                    ints[i][j]=1;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            ArrayList<String> strings = new ArrayList<String>();
            for (int j = 0; j < length; j++) {
                if(ints[i][j]==1){
                    strings.add(strs[j]);
                }
            }
            boolean flag=false;
            int minIndex=Integer.MAX_VALUE;
            int maxIndex=Integer.MIN_VALUE;
            for (int j = 0; j < strings.size(); j++) {
                int index = strs[i].indexOf(strings.get(j));
                minIndex=Integer.min(minIndex,index);
                maxIndex=Integer.max(index+strings.get(j).length(),maxIndex);
            }
            if(minIndex==0&&maxIndex==strs[i].length()){
                flag=true;
            }
            if(flag){
                if(strs[i].length()>maxLength){
                    maxLength=strs[i].length();
                    maxString=strs[i];
                }
            }
        }
        System.out.println(maxString);

    }


    public static void main(String[] args) {
        HwTest5 hwTest5 = new HwTest5();
        hwTest5.findLongest();
    }
}
