package ThreadPractice.Guarded_Suspension;

import java.util.Random;

//try to put the requests in the queue
public class ClientThread extends Thread{
    private final RequestQueue requestQueue;

    public ClientThread(String name,RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            Request request = new Request("No:"+i);
            requestQueue.putRequest(request);
            System.out.println(Thread.currentThread().getName() + " requests "+request);
            try {
                Thread.sleep(new Random(369258).nextInt(1000));
            }catch (InterruptedException e){
                //do nothing
            }
        }
    }
}
