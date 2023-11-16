import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class DrawClock extends JPanel {
    boolean change = false;
    int minuteDispetcher = 0;
    int hourDispetcher= 0;

    public void onClick(Integer action){ //on button click actions (calling from main)
        switch(action){
            case 0: change = !change; break;
            case 1: if(change) minuteDispetcher+=1; else hourDispetcher+=1; break;
            case 2: if(change) minuteDispetcher-=1; else hourDispetcher-=1; break;
        }
    }

    @Override
    public Dimension getPreferredSize() { //window size parameter
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        LocalTime time = LocalTime.now(); //get current time
        int minutes = time.getMinute();
        int hours = time.getHour();
        int seconds = time.getSecond();

        g2d.setColor(Color.BLACK); //fill in the background
        g2d.fillRect(0, 0, 1000, 1000);

        g2d.setColor(Color.WHITE);
        g2d.translate(500, 500); //move pen to the center

        for (int i = 0; i < 12; i++) { //draw the hour markers
            g2d.drawLine(0, -330, 0, -400); //the first one will be 12 hours (default position)
            g2d.rotate(Math.PI / 6);
        }
        //pen back to default position
        g2d.rotate(seconds * Math.PI / 30); //seconds
        g2d.drawLine(0, 0, 0, -290);
        g2d.rotate(2 * Math.PI - seconds * Math.PI / 30);//to rotate pen to 12 hours (preparing for drawing minutes arrow)

        if(change) //when minute arrow is chosen it will be highlighted
            g2d.setColor(Color.CYAN);

        g2d.rotate((minutes + minuteDispetcher) * Math.PI / 30); // minutes
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(0, 0, 0, -250);
        g2d.rotate(2 * Math.PI - (minutes + minuteDispetcher) * Math.PI / 30); //to rotate pen to 12 hours (preparing for drawing hour arrow)

        if(!change) //same for hour arrow
            g2d.setColor(Color.CYAN);
        else
            g2d.setColor(Color.WHITE);

        g2d.rotate((hours + hourDispetcher) * Math.PI / 6);//hours
        g2d.setStroke(new BasicStroke(6));
        g2d.drawLine(0, 0, 0, -200);

        g2d.dispose();//prohibit for pan to write new graphics elements

    }

    public DrawClock() {

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
}
