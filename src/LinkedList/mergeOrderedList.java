package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/7.
 */
public class mergeOrderedList {
    public Node merge(Node head1,Node head2){
        Node head = head1.value <= head2.value ? head1 : head2;

        Node cur1 = head == head1 ? head1 : head2;//lower
        Node cur2 = head == head1 ? head2 : head1;//higher
        while (cur1 != null || cur2 != null){

        }
    }
}

