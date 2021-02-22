package ObjectMethodLearn;

public class Main {
    public static void main(String[] args) {

        WorkActivity work = new WorkActivity();
        RelaxActivity relax = new RelaxActivity();
        System.out.println("" + relax.isInterface());
        Activity activity = new WorkActivity();
        Actor actor = new Actor("Robot", activity);
        actor.myAction();
        activity = new RelaxActivity();
        actor.setActivity(activity);
        actor.myAction();


    }
}
