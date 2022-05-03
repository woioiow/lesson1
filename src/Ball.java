import java.awt.*;

public class Ball extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(color_red,color_green,color_blue));
        g.fillArc(x,y,20,20,0,360);
    }

    public void move()
    {
        x = x+60;
        y = y+60;
    }
}
