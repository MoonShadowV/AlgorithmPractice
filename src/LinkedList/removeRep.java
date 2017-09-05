package LinkedList;

import java.util.HashMap;

/**
 * Created by ShadowMoon on 2017/9/5.
 */
//P71

public class removeRep {

    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void removeRep1(Node head){
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();
        Node cur = head;
        Node pre = null;
        while (cur != null){
            if (map.isEmpty()){
                map.put(cur.value,cur);
                cur = cur.next;
            }
            else if (map.containsKey(cur.value)){
                pre.next = cur.next;
            }
            else {
                map.put(cur.value,cur);
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeRep2(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            pre = cur;
            next = cur.next;
            while (next != null){
                if (cur.value == next.value){
                    pre.next = next.next;
                }else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
