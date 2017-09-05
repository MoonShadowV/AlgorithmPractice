package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/4.
 */
//P52
public class ListPartition {
    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public Node ListPartition(Node head,int pivot){
        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node bigHead = null;
        Node bigTail = null;

        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (smallHead == null){
                    smallHead = head;
                    smallTail = head;
                }else {
                    smallHead.next = head;
                    smallTail = head;
                }
            }

            if (head.value == pivot){
                if (equalHead == null){
                    equalHead = head;
                    equalTail = head;
                }else {
                    equalHead.next = head;
                    equalTail = head;
                }
            }

            if (head.value > pivot){
                if (bigHead == null){
                    bigHead = head;
                    bigTail = head;
                }else {
                    bigHead.next = head;
                    bigTail = head;
                }
            }

            head = next;
        }

        if (smallHead != null){
            smallTail.next = equalHead;
            equalTail = equalTail == null ? smallTail:equalTail;
        }

        if (equalTail != null){
            equalTail.next = bigHead;
        }

        return smallHead != null ? smallHead : (equalHead != null ? equalHead :bigHead);
    }


}
