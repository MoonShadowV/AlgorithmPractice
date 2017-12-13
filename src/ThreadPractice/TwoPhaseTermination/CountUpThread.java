package ThreadPractice.TwoPhaseTermination;

public class CountUpThread extends Thread{
    private long counter = 0;

    private volatile boolean shutdownRequested = false;

    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    public void setShutdownRequested(){
        shutdownRequested = true;
        interrupt();
    }

    private void doWork() throws InterruptedException{
        counter++;
        System.out.println("doWork : counter:"+counter);
        Thread.sleep(500);
    }

    private void doShutdown(){
        System.out.println("doShutdown : counter:"+counter);
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()){
                doWork();
            }
        }catch (InterruptedException e){
//            e.printStackTrace();
        }finally {
            doShutdown();
        }
    }
}
