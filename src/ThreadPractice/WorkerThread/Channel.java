package ThreadPractice.WorkerThread;

public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;

    private int tail;
    private int head;
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threadNum){
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        threadPool = new WorkerThread[threadNum];
        for (int i = 0;i < threadPool.length; i++){
            threadPool[i] = new WorkerThread("Worker-"+i,this);
        }
    }

    public void startWorkers(){
        for(WorkerThread i : threadPool){
            i.start();
        }
    }

    public synchronized void putRequest(Request request){
        while (count >= requestQueue.length){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1)% requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request getRequest(){
        while (count <= 0){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        requestQueue[head] = null;
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
