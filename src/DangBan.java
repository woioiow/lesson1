import java.awt.*;

public class DangBan extends Shape{


    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(color_red,color_green,color_blue));
        g.fillRect(x,y,60,20);
    }
}
