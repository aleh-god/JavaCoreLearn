package PaternLearn.FacadeLearn;

public class Main {
    public static void main(String[] agrs) {
        //Компоненты создаются прямо в ходе тестирования. Обычно клиент получает фасад, а не создает его.
        PopcornPopper popper = new PopcornPopper();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        Projector projector = new Projector();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Tuner tuner = new Tuner();
        Amplifier amp = new Amplifier();

        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(amp, tuner, dvd, cd,
                        projector, screen, lights, popper);
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}
