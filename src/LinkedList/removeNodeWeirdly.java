package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/7.
 */
public class removeNodeWeirdly {
    public void removeWeirdly(Node node){
        if (node == null){
            return;
        }
        Node next = node.next;
        if (next == null){
            throw new RuntimeException("Can't remove last node");
        }
        node.value = next.value;
        node.next = next.next;
    }
}
