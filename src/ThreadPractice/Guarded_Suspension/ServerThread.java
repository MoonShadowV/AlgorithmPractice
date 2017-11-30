package ThreadPractice.Guarded_Suspension;

import java.util.Random;

//try to get the request and print it
public class ServerThread extends Thread {
    private final RequestQueue requestQueue;

    public ServerThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10000; i++){
            Request request = requestQueue.getRequest();
            requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles "+request);
            try {
                Thread.sleep(new Random(12345).nextInt(1000));
            }catch (InterruptedException  e){
                e.printStackTrace();
            }
        }
    }
}
