package LinkedList;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/9/4.
 */
public class addList {
    public class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node addList1(Node l1,Node l2){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        Node h1 = l1;
        Node h2 = l2;

        while (h1 != null){
            s1.push(h1.value);
            h1 = h1.next;
        }
        while (h2 != null){
            s2.push(h2.value);
            h2 = h2.next;
        }

        int CA = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node cur = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0:s1.pop();
            n2 = s2.isEmpty() ? 0:s2.pop();
            n = n1+n2+CA;
            cur = pre;
            pre = new Node(n%10);
            pre.next = cur;
            CA = n/10;
        }
        if (CA == 1){
            cur = pre;
            pre = new Node(1);
            pre.next = cur;
        }

        return pre;
    }


}
