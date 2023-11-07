package Solution;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Classname Solution0322
 * @Description TODO
 * @Date 2023-10-15 21:31
 * @Created by ChenMX
 */
public class Solution0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character, Integer>, List<String>> stringMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                if(!map.containsKey(aChar)){
                    map.put(aChar,0);
                }
                map.put(aChar,map.get(aChar)+1);
            }
            boolean hasAdd=false;
            for (Map<Character, Integer> targetMap : stringMap.keySet()) {
                if(targetMap.size()==map.size()){
                    boolean equal=true;
                    for (Character character : map.keySet()) {
                        if(targetMap.get(character)!=map.get(character)){
                            equal=false;
                            break;
                        }
                    }
                    if(equal){
                        List<String> strings = stringMap.get(targetMap);
                        strings.add(str);
                        hasAdd=true;
                        break;
                    }
                }
            }
            if(!hasAdd){
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                stringMap.put(map,strings);
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        for (List<String> value : stringMap.values()) {
            lists.add(value);
        }
        return lists;
    }

}
