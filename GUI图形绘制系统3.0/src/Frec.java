import java.awt.*;
import java.io.Serializable;

public class Frec extends Myshape implements Serializable
{
    Frec(int x1,int y1,int x2,int y2,Color color,float width)
    {
        super(x1,y1,x2,y2,color,width);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(this.width));

        if(x2>=x1&&y2>=y1){
            g.fillRect(x1,y1,x2-x1,y2-y1);
       }
        else if(x2>=x1&&y2<=y1){
            g.fillRect(x1,y2,x2-x1,y1-y2);
        }
        else if(x2<=x1&&y2>=y1){
            g.fillRect(x2,y1,x1-x2,y2-y1);
        }
        else{
            g.fillRect(x2,y2,x1-x2,y1-y2);
        }
    }
}
