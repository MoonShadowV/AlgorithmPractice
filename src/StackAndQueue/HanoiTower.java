package StackAndQueue;

import java.util.Stack;

/**
 * Created by ShadowMoon on 2017/8/27.
 */

//P17
public class HanoiTower {
    private enum Action{Stay,LTM,MTL,MTR,RTM}
    private Action[] record;
    private int minStep;

    private static String left = "left";
    private static String mid = "mid";
    private static String right = "right";

    private Stack<Integer> ls;
    private Stack<Integer> ms;
    private Stack<Integer> rs;


    public HanoiTower(int num) {
        this.ls = new Stack<Integer>();
        this.ms = new Stack<Integer>();
        this.rs = new Stack<Integer>();
        this.record = new Action[]{Action.Stay};
        this.minStep = 0;
        //避免出栈时空栈
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);


        for (int i = num;i>0;i--){
            ls.push(i);
        }

        while (rs.size() < num+1){
            dealHanoiTower(ls,ms,record,Action.LTM,Action.MTL,left,mid);//try left to mid
            dealHanoiTower(ms,ls,record,Action.MTL,Action.LTM,mid,left);//try mid to left
            dealHanoiTower(ms,rs,record,Action.MTR,Action.RTM,mid,right);//try mid to right
            dealHanoiTower(rs,ms,record,Action.RTM,Action.MTR,right,mid);//try right to mid
        }
    }


    private void dealHanoiTower(Stack<Integer> fromStack,Stack<Integer> toStack,Action[] record,
                              Action nowAction,Action oppsiteAction,String from,String to){
        while (fromStack.peek() < toStack.peek() && record[0] != oppsiteAction){
            System.out.println("Move    "+fromStack.peek()+"    from    "+from+"    to    "+to);
            toStack.push(fromStack.pop());
            record[0] = nowAction;
            minStep += 1;
        }
    }

    public int getMinStep() {
        return minStep;
    }

    public static void main(String[] args){
        HanoiTower han = new HanoiTower(6);
        System.out.print(han.getMinStep());
    }
}
