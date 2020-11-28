package PaternLearn.CommandLearn;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {

        //В этой версии пульт будет поддерживать все семь команд «вкл/выкл», которые будут храниться в соответствующих массивах.
        onCommands = new Command[7];
        offCommands = new Command[7];

        //Конструктор создает экземпляры команд и инициализирует массивы onCommands и offCommands.
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    //Метод setCommand() получает ячейку и команды включения/выключения для этой ячейки.
    // Команды сохраняются в массивах для последующего использования.
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    //Переопределенный метод toString() выводит все ячейки с соответствующими командами.
    // Мы воспользуемся им при тестировании пульта.
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] =" + onCommands[i].getClass().getName() + "=  =" + offCommands[i].getClass().getName() + "=\n");
        }
        return stringBuff.toString();
    }
}