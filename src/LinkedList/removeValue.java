package LinkedList;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/9/5.
 */
//P73
public class removeValue {
    public Node remove1(Node head,int num){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            if (cur.value != num){
                stack.push(cur);
            }
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = cur;
            cur = stack.pop();
        }
        return cur;
    }

    public Node remove2(Node head,int num){
         while (head != null){
             if (head.value != num){
                 break;
             }
             head = head.next;
         }
         Node cur = head;
         Node pre = null;
         while (cur != null){
             if (cur.value == num){
                 pre.next = cur.next;
             }else{
                 pre = cur;
             }
             cur = cur.next;
         }
         return head;
    }

}

