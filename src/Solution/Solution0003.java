package Solution;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0003 {

    public int lengthOfLongestSubstring4(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char r = chars[right];
            if (map.containsKey(r)) {
                left = Integer.max(left,map.get(r) + 1);
            }
            max = Integer.max(max, right - left + 1);
            map.put(r, right);
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int max = 1;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char leftChar = charArray[left];
            char rightChar = charArray[right];
            if (right == left) {
                right++;
                continue;
            }
            for (int i = left; i < right; i++) {
                if (rightChar == charArray[i]) {
                    left = i + 1;
                    break;
                }
            }
            max = Math.max(right - left + 1, max);
            if (charArray[left] == leftChar) {
                right++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution0003 solution0003 = new Solution0003();
        solution0003.lengthOfLongestSubstring4("tmmzuxt");
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
    }
}
