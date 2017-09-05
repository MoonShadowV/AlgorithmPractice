package StackAndQueue;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/26.
 */

//P14
public class StackSort {
    private Stack<Integer> helper;
    private int temp;

    public StackSort() {
        this.helper = new Stack<Integer>();
    }

    public Stack<Integer> sort(Stack<Integer> stack){
        while (!stack.isEmpty()){
            temp = stack.pop();
            while (!helper.isEmpty() && helper.peek() < temp  ){
                stack.push(helper.pop());
            }
            helper.push(temp);
        }

        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }

        return stack;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(3);
        stack.push(9);
        stack.push(2);
        stack.push(1);
        stack.push(25);

        StackSort helper = new StackSort();
        stack = helper.sort(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
