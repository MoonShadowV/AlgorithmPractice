package BinaryTree;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/9/9.
 */
public class StackTree {
    public void preOrderStack(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            print(head);
            if (head.right != null){
                stack.push(head.right);
            }
            if (head.left != null){
                stack.push(head.left);
            }
        }
    }

    public void midOrderStack(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                print(head);
                head = head.right;
            }
        }
    }

    public void posOrderStack(Node head){
        if (head == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if (head.left != null){
                s1.push(head.left);
            }
            if (head.left != null){
                s1.push(head.right);
            }
        }


        while (!s2.isEmpty()){
            print(s2.pop());
        }
    }

    private void print(Node node){
        System.out.print(node.value+" ");
    }
}
