package PaternLearn.CommandLearn;

public interface Command {
    //все объекты команд реализуют единый интерфейс, который состоит всего из одного метода.
    public void execute();
    // Отмена последней команды
    public void undo();
}
