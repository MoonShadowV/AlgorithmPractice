package ThreadPractice.ProducerAndConsumer;

import java.util.Random;

public class Producer extends Thread{
    private static int id = 0;
    private final Storage storage;

    public Producer(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    private int nextId(){
        return id++;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(new Random().nextInt(1000));
                String item = "[ Item No." + nextId() + " PRODUCED by " + getName() + " ]";
                storage.putItem(item);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
