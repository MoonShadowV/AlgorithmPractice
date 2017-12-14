package ThreadPractice.ActiveObject.Tools;

class MakeStringRequest extends MethodRequest<String>{
    private final int count;
    private final char fillchar;

    protected MakeStringRequest(Servant servant, FutureResult<String> future,int count,char fillchar) {
        super(servant, future);
        this.count = count;
        this.fillchar = fillchar;
    }

    @Override
    public void execute() {
        Result<String> result = servant.makingString(count,fillchar);
        future.setResult(result);
    }
}
