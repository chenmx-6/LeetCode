package Solution;

public class Solution0983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] ints = new int[days.length];
        ints[0] = Math.min(costs[0], costs[1]);
        ints[0] = Math.min(costs[2], ints[0]);
        for (int i = 1; i < days.length; i++) {
            int cost = ints[i - 1] + ints[0];
            for (int j = i - 1; j >= -1; j--) {
                int day;
                int lastCost;
                if (j == -1) {
                    day = days[i];
                    lastCost = 0;
                } else {
                    day = days[i] - days[j];
                    lastCost = ints[j];
                }
                if (day <= 30) {
                    cost = Math.min(cost, lastCost + costs[2]);
                }
                if (day <= 7) {
                    cost = Math.min(cost, lastCost + costs[1]);
                }
                if (day > 30) {
                    break;
                }
            }
            ints[i] = cost;
        }
        return ints[days.length - 1];
    }


    public static void main(String[] args) {
        int[] days = {1,5,8,9,10,12,13,16,17,18,19,20,23,24,29};
        int[] costs = { 3,12,54};
        Solution0983 solution0983 = new Solution0983();
        int i = solution0983.mincostTickets(days, costs);
        System.out.println(i);
    }
}
