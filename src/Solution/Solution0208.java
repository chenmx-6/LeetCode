package Solution;

/**
 * @author Miles
 * @date 2026/4/5 1:31
 */

public class Solution0208{

}
class Trie {
    private final Node root=new Node();
    private class Node{
        Node[] son=new Node[26];
        boolean end=false;
    }

    public Trie() {

    }

    public void insert(String word) {
        Node cur=root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            Node[] son = cur.son;
            if(son[index]==null){
                son[index]=new Node();
            }
            cur=son[index];
        }
        cur.end=true;
    }

    public boolean search(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            Node[] son = cur.son;
            if(son[index]==null){
                return false;
            }
            cur=son[index];
        }
        if(cur.end){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            Node[] son = cur.son;
            if(son[index]==null){
                return false;
            }
            cur=son[index];
        }
        return true;
    }
}
