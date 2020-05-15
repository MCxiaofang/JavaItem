import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Text extends Myshape implements Serializable
{
    Text(String mytest,int x2,int y2,Color color,float width)
    {
        super();
        this.x2=x2;
        this.y2=y2;
        this.color=color;
        this.width=width;
        this.mytext=mytest;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);

        g.setFont(new Font("宋体",Font.BOLD,(int)this.width*5));
        g.drawString(mytext,(int)x2,(int)y2);
    }
}
