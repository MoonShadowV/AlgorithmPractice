package StackAndQueue;


import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/24.
 */

//P5
    //Stack FILO
    //Queue FIFO
public class StackToQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public StackToQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int data){
        stackPush.push(data);
    }

    public int poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("The Queue is Empty!");
        }
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    public int peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("The Queue is Empty!");
        }

        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }



    public static void main(String[] args){
        StackToQueue MyQueue = new StackToQueue();
        MyQueue.add(5);
        MyQueue.add(9);
        MyQueue.add(21);

        System.out.println(MyQueue.peek());
        System.out.println(MyQueue.poll());
        System.out.println(MyQueue.peek());
    }
}
