import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Myshape
{
    Line(int x1,int y1,int x2,int y2,Color color,float width)
    {
        super(x1,y1,x2,y2,color,width);
    }

    Line(int checkFlow,int x1,int y1,int x2,int y2,Color color,float width)
    {
        super(x1,y1,x2,y2,color,width);
        this.checkFlow=checkFlow;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.width));

        g.drawLine(x1,y1,x2,y2);
    }
}
