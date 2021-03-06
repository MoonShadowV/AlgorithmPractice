package ThreadPractice.FutureModel;

public class FutureData implements Data{
    private RealData realData = null;
    private boolean ready = false;

    @Override
    public synchronized String getContent() {
        try {
            while (!ready){
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return realData.getContent();
    }

    public synchronized void setRealData(RealData realData){
        if (ready){
            return;
        }
        this.realData = realData;
        ready = true;
        notifyAll();
    }
}
