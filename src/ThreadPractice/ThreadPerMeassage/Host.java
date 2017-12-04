package ThreadPractice.ThreadPerMeassage;

public class Host {
    private final Helper helper = new Helper();
    public void request(final int count,final char c){
        System.out.println("Request "+"("+count+" "+ c +") "+"start!");
//        new Thread(){
//            @Override
//            public void run() {
//                helper.handle(count,c);
//            }
//        }.start();
        new Thread(()->helper.handle(count,c)).start();
        System.out.println("Request "+"("+count+" "+ c +") "+"end!");
    }
}
