package LinkedList;

/**
 * Created by ShadowMoon on 2017/8/29.
 */
//P35
public class removeLastKthNode {
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

    public Node remove(Node head,int k){
        if (head == null ||  k < 1){
            return head;
        }
        Node curNode = head;
        while (curNode != null){
            k--;
            curNode = curNode.next;
        }
        if (k == 0){
            head = head.next;
        }
        if (k < 0){
            curNode = head;
            while (k != 0){
                k++;
                curNode = curNode.next;
            }
            curNode.next = curNode.next.next;
        }
        return head;
    }

    public DoubleNode remove(DoubleNode head,int k){
        if (head == null || k < 1){
            return head;
        }

        DoubleNode curNode = head;
        while (curNode != null){
            k--;
            curNode = curNode.next;
        }
        if (k == 0){
            curNode = curNode.next;
            curNode.pre = null;
        }
        if (k < 0){
            curNode = head;
            while (k != 0){
                k++;
                curNode = curNode.next;
            }
            DoubleNode newNext = curNode.next.next;
            curNode.next = newNext;
            if (newNext != null){
                newNext.pre = curNode;
            }
        }
        return head;
    }
}
