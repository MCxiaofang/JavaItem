import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;

public class Rrec extends Myshape implements Serializable
{
    Rrec(int x1,int y1,int x2,int y2,Color color,float width)
    {
        super(x1,y1,x2,y2,color,width);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.width));

        if(x2>=x1&&y2>=y1){
            g.drawRoundRect(x1,y1,x2-x1,y2-y1,(x2-x1)/10,(y2-y1)/10);
        }
        else if(x2>=x1&&y2<=y1){
            g.drawRoundRect(x1,y2,x2-x1,y1-y2,(x2-x1)/10,(y1-y2)/10);
        }
        else if(x2<=x1&&y2>=y1){
            g.drawRoundRect(x2,y1,x1-x2,y2-y1,(x1-x2)/10,(y2-y1)/10);
        }
        else{
            g.drawRoundRect(x2,y2,x1-x2,y1-y2,(x1-x2)/10,(y1-y2)/10);
        }
    }
}
