package ThreadPractice.Guarded_Suspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> requestQueue = new LinkedList<>();

    public synchronized Request getRequest(){
        while (requestQueue.peek() == null){
            try {
                wait();
            }catch (InterruptedException e){
                //do nothing
            }
        }
        return requestQueue.remove();
    }

    public synchronized void putRequest(Request request){
        requestQueue.offer(request);
        notifyAll();
    }
}
