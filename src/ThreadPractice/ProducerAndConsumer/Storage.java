package ThreadPractice.ProducerAndConsumer;

public class Storage {
    private final String[] items;
    private int tail;
    private int head;
    private int itemNum;

    public Storage(int capacity) {
        items = new String[capacity];
        tail = 0;
        head = 0;
        itemNum = 0;
    }

    public synchronized String takeItem() throws InterruptedException{
        while (itemNum == 0){
            wait();
        }
        String item = items[head];
        items[head] = null;
        itemNum--;
        head = (head + 1) % items.length;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + item);

        return item;
    }

    public synchronized void putItem(String item) throws InterruptedException{
        while (items.length == itemNum){
            wait();
        }
        items[tail] = item;
        itemNum++;
        tail = (tail + 1) % items.length;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " puts " + item);
    }
}
