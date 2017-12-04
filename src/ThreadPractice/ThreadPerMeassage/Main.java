package ThreadPractice.ThreadPerMeassage;

public class Main {
    public static void main(String[] args){
        System.out.println("Main Start");
        Host host = new Host();
        host.request(10,'A');
        host.request(10,'B');
        host.request(10,'C');
        System.out.println("Main End");
    }
}
