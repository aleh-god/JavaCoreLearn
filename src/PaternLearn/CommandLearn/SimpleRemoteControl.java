package PaternLearn.CommandLearn;

//пульт оснащен всего одной кнопкой и имеет всего одну ячейку для хранения управляемого устройства
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {}

    // Метод для назначения команды. Может вызываться повторно, если клиент кода захочет изменить поведение кнопки.
    public void setCommand(Command command) {
        slot = command;
    }

    // Метод, вызываемый при нажатии кнопки. Мы просто берем объект команды, связанный с текущей ячейкой, и вызываем его метод execute()
    public void buttonWasPressed() {
        slot.execute();
    }
}