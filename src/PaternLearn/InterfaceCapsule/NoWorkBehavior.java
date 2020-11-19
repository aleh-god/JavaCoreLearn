package PaternLearn.InterfaceCapsule;

public class NoWorkBehavior implements Work {
    @Override
    public String startWork() {
        String work = "No work today!";
        return work;
    }
}