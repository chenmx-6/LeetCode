import java.util.Stack;

/**
 * @Classname Cqueue
 * @Description TODO
 * @Date 2022-9-7 17:52
 * @Created by ChenMX
 */
public class Offer09CQueue {
    Stack<Integer> stackForInsert;
    Stack<Integer> stackForDelete;
    public Offer09CQueue() {
        stackForDelete=new Stack<>();
        stackForInsert=new Stack<>();
    }

    public void appendTail(int value) {
        while(!stackForInsert.isEmpty()){
            Integer pop = stackForInsert.pop();
            stackForDelete.push(pop);
        }
        stackForInsert.push(value);
    }

    public int deleteHead() {
        while(!stackForDelete.isEmpty()){
            Integer pop = stackForDelete.pop();
            stackForInsert.push(pop);
        }
        if(stackForInsert.isEmpty()){
            return -1;
        }else{
            return stackForInsert.pop();
        }
    }

    public static void main(String[] args) {
        Offer09CQueue offer09CQueue = new Offer09CQueue();
        offer09CQueue.deleteHead();
        offer09CQueue.appendTail(5);
        offer09CQueue.appendTail(2);
        offer09CQueue.deleteHead();
        offer09CQueue.deleteHead();
    }

}
