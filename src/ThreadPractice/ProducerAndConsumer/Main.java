package ThreadPractice.ProducerAndConsumer;

public class Main {
    public static void main(String[] args){
        Storage storage = new Storage(10);
        String producer = "Producer";
        String consumer = "Consumer";
        for (int i = 0;i < 10; i++){
            new Producer(producer+i,storage).start();
            new Consumer(consumer+i,storage).start();
        }
    }
}
