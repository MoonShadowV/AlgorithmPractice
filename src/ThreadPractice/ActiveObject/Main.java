package ThreadPractice.ActiveObject;

import ThreadPractice.ActiveObject.Tools.ActiveObject;
import ThreadPractice.ActiveObject.Tools.ActiveObjectFactory;

public class Main {
    public static void main(String[] args){
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice",activeObject).start();
        new MakerClientThread("Bible",activeObject).start();
        new MakerClientThread("Cherry",activeObject).start();
    }
}
