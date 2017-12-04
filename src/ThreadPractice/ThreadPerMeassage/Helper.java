package ThreadPractice.ThreadPerMeassage;

public class Helper {
    public void handle(int count,char c){
        System.out.println("Handle "+"("+count+" "+ c +") "+"start!");
        for (int i = 0; i < count;i++){
            slow();
            System.out.print(c);
        }
        System.out.println("Handle "+"("+count+" "+ c +") "+"end!");
    }

    private void slow(){
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
