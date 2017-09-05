package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/5.
 */
//  P69
public class reverseKNode {
    public class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseKNode(Node head,int k){
        if (k < 2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node end = null;

        Node pre = null;
        Node newHead = head;
        Node next = null;

        int count = 0;
        while (cur != null){
            end = cur.next;
            if (++count == k){
                start = pre == null ? head:pre.next;
                newHead = newHead == head ? cur : newHead;
                while (start != end){
                     next = start.next;
                     start.next = pre;
                     pre = start;
                     start = next;
                }
            }
        }
        return newHead;
    }
}
