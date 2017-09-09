package BinaryTree;

/**
 * Created by ShadowMoon on 2017/9/9.
 */
public class RecurTree {
    public void preOrderRecur(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public void midOrderRecur(Node root){
        if (root == null){
            return;
        }
        midOrderRecur(root.left);
        System.out.println(root.value);
        midOrderRecur(root.right);
    }

    public void posOrderRecur(Node root){
        if (root == null){
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.println(root.value);
    }
}
