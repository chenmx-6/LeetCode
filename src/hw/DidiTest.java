package hw;

public class DidiTest {
    //输入：classes = {{1,2},{3,5},{2,2}}, extraStudents = 2
    //输出：0.78333
    //解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333
    public void maxScore(){
        int[][] classes={{1,2},{3,5},{2,2}};
        int extraStudent=2;
        for (int i = 0; i < extraStudent; i++) {
            double maxScore=0;
            int maxIndex=-1;
            for (int j = 0; j < classes.length; j++) {
                int[] aClass = classes[j];
                double currentScore = (double)(aClass[0] + 1) / (double)(aClass[1] + 1);
                double oldScore = (double)(aClass[0]) / (double)(aClass[1]);
                double d = currentScore - oldScore;
                if(d>maxScore){
                    maxScore=d;
                    maxIndex=j;
                }
            }
            if(maxIndex!=-1){
                classes[maxIndex][0]=classes[maxIndex][0]+1;
                classes[maxIndex][1]=classes[maxIndex][1]+1;
            }
        }

        double total=0;
        for (int i = 0; i < classes.length; i++) {
            double score = (double) classes[i][0] / (double) classes[i][1];
            total+=score;
        }
        System.out.println(total/ (double)classes.length);

    }

    public static void main(String[] args) {
        DidiTest didiTest = new DidiTest();
        didiTest.maxScore();
    }
}
