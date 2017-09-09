package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/9.
 */
public class mergeLR {
    public Node merge(Node head){
        if (head == null || head.next == null){
            return head;
        }

        int len = 0;
        Node cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }

        Node leftTail = head;
        cur = head.next;
        while (cur.next != null && cur.next.next != null){
            leftTail = leftTail.next;
            cur = cur.next.next;
        }

        Node RHead = leftTail.next;
        leftTail.next = null;
        Node LNext = null;
        Node RNext = null;
        cur = head;
        while (cur.next != null){
            LNext = cur.next;
            RNext = RHead.next;

            cur.next = RHead;
            RHead.next = LNext;

            cur = LNext;
            RHead = RNext;
        }
        cur.next = RHead;
        return head;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        mergeLR obj = new mergeLR();
        head = obj.merge(head);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
