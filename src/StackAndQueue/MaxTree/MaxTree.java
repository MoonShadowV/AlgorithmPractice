package StackAndQueue.MaxTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/28.
 */
//P23
public class MaxTree {
    public Node generateMaxTree(int[] arr){
        Node[] array =  new Node[arr.length];
        for (int i = 0;i < arr.length;i++){
            array[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<Node>();
        Map<Node,Node> lSubTree = new HashMap<Node,Node>();//key为value左侧第一个比它小的数
        Map<Node,Node> rSubTree = new HashMap<Node,Node>();//key为value右侧第一个比它小的数

        //排列好每个数左边第一个比它大的数
        for (int i = 0;i < arr.length; i++){
            Node curNode = array[i];
            while (!stack.isEmpty() && curNode.value > stack.peek().value ){
                popStackAndSetMap(stack,lSubTree);
            }
            stack.push(curNode);
        }
        //大部分时候的作用是压入最后一个数
        while (!stack.isEmpty()){
            popStackAndSetMap(stack,lSubTree);
        }

        //排列好每个数右边第一个比它大的数
        for (int i = arr.length-1;i > -1; i--){
            Node curNode = array[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value ){
                popStackAndSetMap(stack,rSubTree);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackAndSetMap(stack,rSubTree);
        }

        Node head = null;
        for(int i = 0;i < arr.length;i++){
            Node curNode = array[i];
            Node left = lSubTree.get(curNode);//寻找curNode左边第一个比它大的数，如果没有则为null
            Node right = rSubTree.get(curNode);

            if (left == null && right == null){
                head = curNode;
            }else if(left == null){
                 if (right.left == null){//先考虑左边，如果有了节点，再考虑右边
                     right.left = curNode;
                 }else {
                     right.right = curNode;
                 }
            }else if(right == null){
                if (left.left == null){
                    left.left = curNode;
                }else {
                    left.right = curNode;
                }
            }else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null){
                    parent.left = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public void popStackAndSetMap(Stack<Node> stack,Map<Node,Node> map){
        Node popNode = stack.pop();
        if (stack.isEmpty()){
            map.put(popNode,null);
        }else {
            map.put(popNode,stack.peek());
        }
    }
}
