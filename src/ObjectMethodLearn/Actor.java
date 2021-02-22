package ObjectMethodLearn;

public class Actor {

    Activity activity;
    String name;

    public Actor(String name, Activity activity) {
        this.name = name;
        this.activity = activity;
    }

    void myAction() {
        activity.action();
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
