
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameCanvas extends JPanel  {

    int width;
    int height;
    JWindow jWindow;
    Ball ball = new Ball();


    Block block = new Block();

    public GameCanvas()
    {
        jWindow = new JWindow();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (d.getWidth()/2);
        height = (int) (d.getHeight()/2);

        this.setSize(width,height);
        jWindow.getContentPane().add(this);
        jWindow.setBounds(((int)d.getWidth()-width)/2,((int)d.getHeight()-height)/2,width,height);
        jWindow.toFront();


        ball.x = 100;
        ball.y = 100;

        ball.color_red = 255;
        ball.color_green = 255;
        ball.color_blue = 0;


        block.x = 200;
        block.y = 200;

        Random random = new Random();

        block.color_red = Math.abs(random.nextInt()%255);
        block.color_green = Math.abs(random.nextInt()%255);
        block.color_blue = Math.abs(random.nextInt()%255);

    }

    int step;
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, getWidth(),getHeight());



        ball.move();
        ball.draw(g);


        block.draw(g);



        step++;
    }


    public void start() {
        repaint();
        new Thread(()->{

            try
            {
                boolean isRunning = true;
                while (isRunning)
                {
                    repaint();
                    Thread.sleep(80);
                }
                Thread.sleep(1000);
                jWindow.setVisible(false);

            }
            catch (Exception e)
            {
            }
        }).start();
        jWindow.setVisible(true);
        jWindow.toFront();
    }
}
