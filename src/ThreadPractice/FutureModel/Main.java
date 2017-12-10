package ThreadPractice.FutureModel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main function -----   BEGIN");
        Host host = new Host();

        Data data1 = host.request("Appache", 3);
        Data data2 = host.request("Bible", 3);
        Data data3 = host.request("Cherry", 3);

        System.out.println("Main otherJob -----   BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main otherJob -----   END");
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
    }
}
