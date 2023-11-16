import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Main {
    public static void main(String[] args) {
        DrawClock panel = new DrawClock(); //panel with buttons and clock

        JButton button = new JButton(); //clickable button to choose minute or hour arrow
        button.setText("Set");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.onClick(0);
            }
        });
        panel.add(button);

        JButton buttonUp = new JButton(); //button to lift arrow up on 1
        buttonUp.setText("Up");
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.onClick(1);
            }
        });
        panel.add(buttonUp);

        JButton buttonDown = new JButton(); //button to lift arrow down on 1
        buttonDown.setText("Down");
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.onClick(2);
            }
        });
        panel.add(buttonDown);

        JFrame frame = new JFrame("analog clocks"); //frame with panel and some other parameters
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
