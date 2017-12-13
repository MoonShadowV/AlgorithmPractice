package ThreadPractice.TwoPhaseTermination;

public class Main {
    public static void main(String[] args){
        System.out.println("Main Function : Begin");
        try{
            CountUpThread t = new CountUpThread();
            t.start();

            Thread.sleep(10000);

            System.out.println("Main Function : shutdownRequest");
            t.setShutdownRequested();

            System.out.println("Main Function : Join");
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main Function End");
    }
}
