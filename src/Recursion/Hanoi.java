package Recursion;

/**
 * Created by ShadowMoon on 2017/9/28.
 */
public class Hanoi {

    public void hanoi1(int n){
        if (n > 0){
            move1(n,"left","mid","right");
        }
    }
    public void move1(int n,String from,String mid,String to){
        if (n == 1){
            System.out.println("Move from "+from+" to "+to);
        }else {
            move1(n-1,from,to,mid);
            move1(1,from,mid,to);
            move1(n-1,mid,from,to);
        }
    }

}

