package ThreadPractice.Guarded_Suspension;

public class Main {
    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread("Client",requestQueue).start();
        new ServerThread("Server",requestQueue).start();
    }
}
