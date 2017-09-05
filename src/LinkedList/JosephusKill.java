package LinkedList;

/**
 * Created by ShadowMoon on 2017/9/1.
 */
//P47
public class JosephusKill {
    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node kill(Node head,int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }

        Node last = head;
        //find the last person
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){//until the last one
            if (++count == m){
                //这个时候last是要删除节点的上一个节点
                last.next = last.next.next;
                count = 0;
            }else {
                last = last.next;
            }
        }
        return head;
    }

    //O（N）解法
    public Node kill2(Node head,int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        int len = 0;
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        int tmp = getAlive(len,m);//通过递归的方式获取最终幸存者在最开始的编号
        cur = head;
        while (--tmp != 0){
            cur = cur.next;
        }
        cur.next = cur;
        return cur;
    }

    private int getAlive(int len,int m){
        if (len == 1){
            return len;
        }
        return (getAlive(len-1,m) + m - 1) % len + 1;//递推式——>fun(i) = [fun(i-1)+m-1]%i+1,i为剩余人数
    }
}
