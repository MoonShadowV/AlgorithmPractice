package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/6.
 */
public class selectionSort {
    public void Sort(Node head){
        Node cur = head;
        Node tail = null;
        Node smallPre = null;
        Node small = head;

        Node node = null;
        Node pre = null;
        while (cur != null){
            //get the smallPre Node
            pre = cur;
            node = cur.next;
            while (node != null){
                if (node.value < small.value){
                    smallPre = pre;
                    small = node;
                }
                pre = node;
                node = node.next;
            }
            //collect small node
            if (smallPre != null){
                head = small;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            //connect the list
            if (tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
    }
}
