package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/7.
 */
public class insertNum {
    public Node insert(Node head,int num){
        Node node = new Node(num);

        Node pre = head;
        Node cur = head.next;
        while (cur != head){
            if (node.value >= pre.value && node.value <= cur.value){
                pre.next = node;
                node.next = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head.value < node.value ? head : node;
    }
}
