package ThreadPractice.ReaderAndWriter;

public final class ReadWriteLock {
    private int readerNum = 0;
    private int writerNum = 0;
    private int waitingWriterNum = 0;
    private boolean prefWriter = true;

    public synchronized void set_ReadLock() throws InterruptedException{
        while (writerNum > 0 || (prefWriter && waitingWriterNum > 0)){
            wait();
        }
        readerNum++;
    }

    public synchronized void unlock_ReadLock(){
        readerNum--;
        prefWriter = true;
        notifyAll();
    }

    public synchronized void set_WriteLock() throws InterruptedException{
        waitingWriterNum++;
        try {
            while (readerNum > 0 || writerNum > 0){
                wait();
            }
        }finally {
            waitingWriterNum--;
        }
        writerNum++;
    }

    public synchronized void unlock_WriteLock(){
        writerNum--;
        prefWriter = false;
        notifyAll();
    }
}
