package PaternLearn.ShablonLearn;

import javax.swing.*;
import java.awt.*;

//Расширяем класс JFrame, который содержит метод update(), управляющий перерисовкой экрана. Чтобы подключиться к этому алгоритму, мы переопределяем метод paint().
public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
    }

    //Алгоритм перерисовки JFrame вызывает paint(). По умолчанию метод paint() не делает ничего... это перехватчик.
    //Переопределенная версия paint() выводит сообщение в окне.
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }
}
