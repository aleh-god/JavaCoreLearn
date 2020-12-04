package PaternLearn.CommandLearn;

public class Main {
    public static void main(String[] agrs) {
        /*
        //Инициатор ему будет передаваться объект команды
        SimpleRemoteControl remote = new SimpleRemoteControl();

        //Создание объекта Light, который будет Получателем запроса.
        Light light = new Light();
        //Создание команды с указанием Получателя.
        LightOnCommand lightOn = new LightOnCommand(light);

        //Команда передается Инициатору.
        remote.setCommand(lightOn);
        //Имитируем нажатие кнопки.
        remote.buttonWasPressed();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();

        */

        // Создание всех устройств.
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        CeilingFan ceilingFan= new CeilingFan("Living Room");

        GarageDoor garageDoor = new GarageDoor();

        Stereo stereo = new Stereo("Магнитола.");

        // Создание команд для света
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        // Создание команд для вентиляции
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);

        // Создание команд для гаража
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
        // Создание команд для музыки
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        //Готовые команды связываются с ячейками пульта.
        // Команды сохраняются в массивах для последующего использования.
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(4, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(5, ceilingFanLowCommand, ceilingFanHighCommand);

        //Переписанный вручную (переопределенный) метод toString() преобразует объект в строку, как нам удобно
        System.out.println("\nСписок ячеек и связанных с ними команд:");
        System.out.println(remoteControl);

        //Пульт готов к проверке!
        //Перебираем все ячейки, и для каждой ячейки имитируем нажатие кнопок «вкл» и «выкл».
        System.out.println("\nПроверяем выполнение простых команд:");
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed(); // Используем кнопку Отмена

        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);

        System.out.println("\nЗадаем сложное управление вентилятором:");
        System.out.println("Включаем вентилятор");
        remoteControl.onButtonWasPushed(4);

        System.out.println("Добавляем скорость");
        remoteControl.offButtonWasPushed(5);
        remoteControl.offButtonWasPushed(5);

        System.out.println("Используем кнопку Отмена");
        remoteControl.undoButtonWasPushed(); // Используем кнопку Отмена

        System.out.println("Выключаем вентилятор");
        remoteControl.offButtonWasPushed(4);

        System.out.println("Включаем на старой скорости");
        remoteControl.onButtonWasPushed(4);

        System.out.println("Уменьшаем скорость");
        remoteControl.onButtonWasPushed(5);
        remoteControl.onButtonWasPushed(5);

        System.out.println("Используем кнопку Отмена");
        remoteControl.undoButtonWasPushed(); // Используем кнопку Отмена

        //
        System.out.println("\nИспользуем макро-команды:");
        Command[] macroON = {livingRoomLightOn , kitchenLightOn , ceilingFanOn};
        Command[] macroOff = {livingRoomLightOff , kitchenLightOff , ceilingFanOff};

        MacroCommand houseOn = new MacroCommand(macroON);
        MacroCommand houseOff = new MacroCommand(macroOff);

        remoteControl.setCommand(6 , houseOn , houseOff);

        System.out.println("Хозяин приехал домой. Встречаем!");
        remoteControl.onButtonWasPushed(6);

        System.out.println("Хозяин покидает дом. Досвидания!");
        remoteControl.offButtonWasPushed(6);


        System.out.println(remoteControl);
    }
}