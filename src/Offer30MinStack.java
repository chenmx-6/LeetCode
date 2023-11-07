import java.util.Stack;

/**
 * @Classname Offer30MinStack
 * @Description TODO
 * @Date 2022-9-7 18:20
 * @Created by ChenMX
 */
public class Offer30MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public Offer30MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int min;
        if (!minStack.isEmpty()) {
            min = minStack.peek();
        }else{
            min=x;
        }
        minStack.push(Integer.min(x, min));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
