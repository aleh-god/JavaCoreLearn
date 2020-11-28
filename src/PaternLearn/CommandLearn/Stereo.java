package PaternLearn.CommandLearn;

public class Stereo {
    String nameMedia;

    public Stereo(String nameMedia) {
        this.nameMedia = nameMedia;
    }

    public void on() {
        System.out.println("Включаем " + this.nameMedia);
    }

    public void off() {
        System.out.println("Выключаем " + this.nameMedia);
    }

    public void setCD() {
        //
    }

    public void setVolume(int i) {
        System.out.println("Громкость выставлена на " + i);
    }
}
