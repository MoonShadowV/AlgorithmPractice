package ThreadPractice;

public class PrintThread extends Thread{
    private static int order = 0;
    private void add(){
        order++;
        System.out.println(order);
    }
    @Override
    public void run() {
        add();
    }

    public static void main(String[] args){
        for (int i = 0 ; i < 100; i++){
            new Thread(new PrintThread()).start();
        }
        PrintThread t = new PrintThread();
        t.start();
    }
}
