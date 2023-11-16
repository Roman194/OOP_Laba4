import javax.swing.*;

public  class Main {
    public static void main(String[] args) {

        DrawClock panel = new DrawClock();
        JFrame frame = new JFrame("analog clocks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
