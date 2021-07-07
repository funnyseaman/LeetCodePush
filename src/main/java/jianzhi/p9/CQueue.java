package jianzhi.p9;

import org.junit.Test;

import java.util.Stack;

public class CQueue {

    private Stack<Integer> addStack;
    private Stack<Integer> delStack;

    public CQueue() {
        addStack = new Stack<>();
        delStack = new Stack<>();
    }

    public void appendTail(int value) {
        addStack.add(value);
    }

    public int deleteHead() {
        if (delStack.empty()) {
            if (addStack.empty()) {
                return -1;
            } else {
                while (!addStack.empty()) {
                    delStack.add(addStack.pop());
                }
            }
        }
        return delStack.pop();
    }


    @Test
    public void test() {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(1);
    }
}
