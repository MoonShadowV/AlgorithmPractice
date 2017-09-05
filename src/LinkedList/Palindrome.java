package LinkedList;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/9/2.
 */
//P48
public class Palindrome {
    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Boolean isPalidrome(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (stack.pop().value != cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    //O(N)
    public Boolean isPalidrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        Node right = cur.next;
        while (cur.next != null && cur.next.next != null){//查找右半边的第一个节点
            cur = cur.next.next;
            right = right.next;
        }
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (stack.pop().value != cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }


}
