package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ShadowMoon on 2017/9/4.
 */
//P58
public class copyListWithRand {
    public class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node copyListWithRand1(Node head){
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node cur  = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //use less space——>O(1)
    public Node copyListWithRand2(Node head){
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        while (cur != null){
            curCopy = cur.next;
            next = cur.next.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }

        cur = head;
        Node newHead = head.next;
        Node newCur = null;
        while (cur != null){
            newCur = cur.next;
            next = cur.next.next;
            newCur.next = next.next == null ? null : next.next;
            cur = next;
        }

        return newHead;
    }
}
