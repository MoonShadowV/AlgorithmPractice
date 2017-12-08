package ThreadPractice.WorkerThread;

import java.util.Random;

public class Request {
    private final String name;
    private final int id;
    private static final Random random = new Random();

    public Request(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executes "+this);
        try {
            Thread.sleep(random.nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[ Request from "+ name + " No."+id+" ]";
    }
}
