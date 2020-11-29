package PaternLearn.CommandLearn;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    //Мы добавим новую переменную экземпляра для отслеживания последней команды. Далее при нажатии кнопки отмены мы обращаемся к этой команде и вызываем ее метод undo().
    Command undoCommand;

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
        //В переменную undoCommand изначально также заносится объект NoCommand, чтобы при нажатии кнопки отмены ранее любых других кнопок ничего не происходило.
        undoCommand = noCommand;
    }

    //Метод setCommand() получает ячейку и команды включения/выключения для этой ячейки.
    // Команды сохраняются в массивах для последующего использования.
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        //Сохраняем выполняемую команду, если надо будет потом отменить
        undoCommand = onCommands[slot];
    }
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    //При нажатии кнопки отмены мы вызываем метод undo() команды, хранящейся в переменной undoCommand.
    //Вызов отменяет операцию последней выполненной команды.
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    // Переопределенный метод toString() для объекта remoteControl и метода System.out.println
    // Выводит все ячейки с соответствующими командами. Мы воспользуемся им при тестировании пульта.
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] =" + onCommands[i].getClass().getName() + "=  =" + offCommands[i].getClass().getName() + "=\n");
        }
        return stringBuff.toString();
    }
}