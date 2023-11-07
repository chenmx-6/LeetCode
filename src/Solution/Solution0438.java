package Solution;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname Solution0438
 * @Description TODO
 * @Date 2023-11-6 15:03
 * @Created by ChenMX
 */
public class Solution0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int length = p.length();
        if(length>s.length()){
            return new ArrayList<>();
        }
        char[] targetChars = p.toCharArray();
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char targetChar : targetChars) {
            if(!targetMap.containsKey(targetChar)){
                targetMap.put(targetChar,0);
            }
            targetMap.put(targetChar,targetMap.get(targetChar)+1);
        }

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> currentMap = new HashMap<>();
        for (int j = 0; j < length; j++) {
            char aChar = chars[j];
            if(!currentMap.containsKey(aChar)){
                currentMap.put(aChar,0);
            }
            currentMap.put(aChar,currentMap.get(aChar)+1);
        }

        HashMap<Character, Integer> differentMap = new HashMap<>();
        for (Character character : targetMap.keySet()) {
            if(currentMap.containsKey(character)){
                differentMap.put(character,currentMap.get(character)-targetMap.get(character));
            }else{
                differentMap.put(character,0-targetMap.get(character));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= chars.length-length; i++) {
            if(i>=1){
                char removeChar = chars[i - 1];
                char addChar = chars[i + length - 1];
                if(differentMap.containsKey(removeChar)){
                    Integer preValue = differentMap.get(removeChar);
                    differentMap.put(removeChar,preValue-1);
                }
                if(differentMap.containsKey(addChar)) {
                    Integer preValue = differentMap.get(addChar);
                    differentMap.put(addChar,preValue+1);
                }
            }
            boolean equal=true;
            for (Integer value : differentMap.values()) {
                if(value!=0){
                    equal=false;
                }
            }
            if(equal){
                result.add(i);
            }
        }
        return result;
    }
}
