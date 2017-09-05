package LinkedList;

/**
 * Created by ShadowMoon on 2017/8/29.
 */
//P38 
public class removeNode {
    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node removeMidNode(Node head){
        if (head==null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node preNode = head;
        Node curNode = head.next.next;
        while (curNode.next != null && curNode.next.next != null){
            preNode = preNode.next;
            curNode = curNode.next.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }

    public Node removeNodeByRatio(Node head,int a,int b){
        if(a < 1 || a > b){
            return head;
        }
        Node cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }

        int pos = (int)Math.ceil((double)(a*len)/b);
        if (pos == 1){
            return head.next;
        }
        while (--pos > 1){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
