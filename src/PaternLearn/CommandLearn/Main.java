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
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(4, garageDoorUp, garageDoorDown);

        //Метод toString() выводит список ячеек и связанных с ними команд.
        System.out.println(remoteControl);

        //Пульт готов к проверке!
        //Перебираем все ячейки, и для каждой ячейки имитируем нажатие кнопок «вкл» и «выкл».
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
    }
}