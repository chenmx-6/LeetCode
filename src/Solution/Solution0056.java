package Solution;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author chenmx
 * @date 2026-3-31
 **/

public class Solution0056 {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int min = intervals[i][0];
            int max = intervals[i][1];
            int[] mergeInts = intervals[i];

            for (int j = ints.size() - 1; j >= 0; j--) {
                int[] anInt = ints.get(j);
                int left = anInt[0];
                int right = anInt[1];
                if (min >= left && min <= right || left >= min && left <= max) {
                    mergeInts[0] = Integer.min(left, mergeInts[0]);
                    mergeInts[1] = Integer.max(right, mergeInts[1]);
                    ints.remove(anInt);
                }
            }
            ints.add(mergeInts);
        }
        int[][] res = new int[ints.size()][intervals[0].length];
        for (int i = 0; i < ints.size(); i++) {
            int[] anInt = ints.get(i);
            res[i][0] = anInt[0];
            res[i][1] = anInt[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution0056 solution0056 = new Solution0056();
        int[][] merge = solution0056.merge(ints);
        System.out.println(merge);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (p1, p2) -> p1[0] - p2[0]);
        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0 && ints.get(ints.size() - 1)[1] >= intervals[i][0]) {
                int[] target = ints.get(ints.size() - 1);
                int right = target[1];
                target[1] = Integer.max(right, intervals[i][1]);
            } else {
                ints.add(intervals[i]);
            }

        }
        return ints.toArray(new int[ints.size()][]);
    }
}
