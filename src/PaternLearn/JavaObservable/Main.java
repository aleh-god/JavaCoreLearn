package PaternLearn.JavaObservable;

public class Main {
    public static void main(String[] agrs) {
        Server server = new Server();
        Vidget vidget = new Vidget(server);
        Vijet vijet = new Vijet(server);
        server.setData("Pong!");
    }
}
