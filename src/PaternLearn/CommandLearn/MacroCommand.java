package PaternLearn.CommandLearn;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        //Сохраняем очередь команд
        this.commands = commands;
    }
    public void execute() {
        //Последовательно выполняем все команды
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
        commands[i].undo();
        }
    }
}