package StackAndQueue;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/24.
 */
//P2
public class GetMin {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMin() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

        public int pop(){
            if (stackMin.isEmpty()) {
                throw new RuntimeException("The Stack is empty.");
            }

            if (stackData.peek().equals(stackMin.peek())){
                stackMin.pop();
            }
            return stackData.pop();
        }

        public void push(int newData){
            stackData.push(newData);
            if (stackMin.isEmpty()){
                stackMin.push(newData);
            }else if (stackMin.peek() >= newData){
                stackMin.push(newData);
            }
        }

        public int getMin(){
            if(stackMin.isEmpty()){
                throw new RuntimeException("The Stack is empty.");
            }else {
                return stackMin.peek();
            }
        }

    public static void main(String[] args){
            GetMin Stack = new GetMin();
            Stack.push(5);
            Stack.push(8);
            Stack.push(2);
            Stack.push(9);

            System.out.println(Stack.getMin());
    }
}
