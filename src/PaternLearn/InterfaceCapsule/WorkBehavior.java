package PaternLearn.InterfaceCapsule;

public class WorkBehavior implements Work {
    @Override
    public String startWork() {
        String work = "I am working now!";
        return work;
    }
}
