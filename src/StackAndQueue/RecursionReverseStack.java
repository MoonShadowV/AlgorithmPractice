package StackAndQueue;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/25.
 */
//P8

public class RecursionReverseStack {
    private Stack<Integer> Mystack;

    public RecursionReverseStack() {
        this.Mystack = new Stack<Integer>();
    }

    public int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int element = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(element);
    }
}
