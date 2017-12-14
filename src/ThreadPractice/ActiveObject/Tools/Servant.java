package ThreadPractice.ActiveObject.Tools;

public class Servant implements ActiveObject {
    @Override
    public Result<String> makingString(int count, char fillchar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count;i++){
            stringBuilder.append(fillchar);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return new RealResult<String>(stringBuilder.toString());
    }

    @Override
    public void displayString(String string) {
        try {
            System.out.println("displayString: "+ string);
            Thread.sleep(10);
        }catch (InterruptedException e){
        }
    }

}
