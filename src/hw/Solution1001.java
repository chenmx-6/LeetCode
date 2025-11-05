package hw;

/**
 * @author Miles
 * @date 2025/10/8 20:54
 */
public class Solution1001 {
    public boolean checkGoodStudent (String scoreStr) {
        // write code here
        String[] scores = scoreStr.split(";");
        String score = scores[0];
        String pe = scores[1];
        String labor = scores[2];
        int scoreNum = Integer.parseInt(score);
        int peNum = Integer.parseInt(pe);
        int laborNum = Integer.parseInt(labor);
        if(scoreNum<280)return false;
        if(peNum<90)return false;
        if(laborNum<5)return  false;
        return true;
    }
}
