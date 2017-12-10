package ThreadPractice.FutureModel;

public class RealData implements Data{
    private final String content;
    public RealData(String str,int times){
        System.out.println("Making RealData -- "+str+"  BEGIN");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < times; i++){
            stringBuilder.append(str);
        }

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        content = stringBuilder.toString();
        System.out.println("Making RealData -- "+str+"  END");
    }
    @Override
    public String getContent() {
        return content;
    }
}
