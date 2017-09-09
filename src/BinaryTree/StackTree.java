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
    }
}
