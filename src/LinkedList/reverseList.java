package LinkedList;

/**
 * Created by ShadowMoon on 2017/8/31.
 */
//P42
public class reverseList {
    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverse(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node reverse(Node head,int from,int to){
        int len = 0;
        Node cur = head;
        Node pre = null;
        Node later = null;
        while (cur != null){
            len++;
            pre = len == from - 1?cur:pre;
            later = len == to + 1 ?cur:later;
            cur = cur.next;
        }
        if (from < 1 || from > to || to > len){
            return head;
        }
        Node node1 = pre == null ? head:pre.next;
        Node node2 = node1.next;
        node1.next = later;
        Node nextNode = null;
        while (node2 != later){
            nextNode = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = nextNode;
        }

        if (pre != null){
            pre.next = node1;
            return head;
        }

        return node1;
    }

}
