package ThreadPractice.FutureModel;

public class Host {
    public Data request(final String str,final int times) {
        System.out.println("Making request -- " + str + "  BEGIN");

        final FutureData futureData = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(str, times);
            futureData.setRealData(realData);
        }).start();

        System.out.println("Making request -- " + str + "  END");

        return futureData;
    }
}
