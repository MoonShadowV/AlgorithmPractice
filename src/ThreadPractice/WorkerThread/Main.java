package ThreadPractice.WorkerThread;

public class Main {
    public static void main(String[] args){
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Tom ",channel).start();
        new ClientThread("Emily",channel).start();
    }
}
