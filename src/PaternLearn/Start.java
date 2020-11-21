package PaternLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    JFrame frame;
    public static void main(String[] agrs) {
        Start start = new Start();
        start.go();
    }
    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Hello button!");
        //Определяем наблюдателей за изменением кнопки
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());

        //Set Frame this
        button.setBounds(130,100,150, 40);//x axis, y axis, width, height
        frame.add(button);//adding button in JFrame
        frame.setSize(400,500);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible
    }

    // Внутренние классы набюдателей
    class AngelListener implements ActionListener {
        // Когда изменяется объект, вызывается вместо update -> action
        public void actionPerformed(ActionEvent event) {
            System.out.println("В небе ангелочки!");
        }
    }

    class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("В аду дьяболочки!!!");
        }
    }
}
