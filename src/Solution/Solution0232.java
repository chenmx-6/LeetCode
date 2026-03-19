package Solution;

import java.util.Stack;

/**
 * @author Miles
 * @date 2025/11/17 13:20
 */
public class Solution0232 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public Solution0232() {
        inStack=new Stack();
        outStack=new Stack();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.empty()){
            while(!inStack.empty()){
                Integer pop = inStack.pop();
                outStack.push(pop);
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.empty()){
            while(!inStack.empty()){
                Integer pop = inStack.pop();
                outStack.push(pop);
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        if(outStack.empty()){
            if(inStack.empty()){
                return true;
            }
        }
        return false;
    }
}
