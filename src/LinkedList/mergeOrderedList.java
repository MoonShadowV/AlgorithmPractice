package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/7.
 */
//P85
public class mergeOrderedList {
    public Node merge(Node head1,Node head2){
        Node head = head1.value <= head2.value ? head1 : head2;

        Node cur1 = head == head1 ? head1 : head2;//The lower one is the base list
        Node cur2 = head == head1 ? head2 : head1;

        Node pre = null;
        Node tmp = null;
        while (cur1 != null && cur2 != null){
            if (cur1.value <= cur2.value){
            }else {
                pre = cur1;
                cur1 = cur1.next;
                tmp = cur2.next;
                pre.next = cur2;
                pre = pre.next;
                cur2.next = cur1;
                cur2 = tmp;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }
}

