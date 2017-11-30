package ThreadPractice.ProducerAndConsumer;

import java.util.Random;

public class Consumer extends Thread {
    private final Storage storage;

    public Consumer(String name,Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true){
                String item = storage.takeItem();
                System.out.println(Thread.currentThread().getName() + " consumes "+ item);
                Thread.sleep(new Random().nextInt(800));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
