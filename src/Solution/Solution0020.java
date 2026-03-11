package Solution;

import java.util.HashSet;
import java.util.Stack;

public class Solution0020 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        HashSet<Character> addSet = new HashSet<>();
        addSet.add('[');
        addSet.add('(');
        addSet.add('{');
        HashSet<Character> deleteSet = new HashSet<>();
        deleteSet.add(')');
        deleteSet.add(']');
        deleteSet.add('}');
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(addSet.contains(c)){
                characters.add(c);
            }else{
                Character pop = characters.pop();
//                if()
            }
        }
        return false;
    }
}
