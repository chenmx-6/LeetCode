package domain;

/**
 * @author Miles
 * @date 2026/3/7 22:33
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
