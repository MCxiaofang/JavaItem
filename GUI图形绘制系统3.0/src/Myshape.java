import java.awt.*;
import java.io.Serializable;

public abstract class Myshape implements Serializable
{
    public int x1,y1;                   //鼠标按下坐标
    public int x2,y2;                   //鼠标释放坐标
    public int checkFlow;                   //鼠标前一时刻坐标
    public Color color;                 //画笔颜色
    public float width;                   //画笔粗细
    public String mytext;

    Myshape()
    {
        this.x1=0;this.y1=0;
        this.x2=0;this.y2=0;
        this.checkFlow=0;
        this.color=Color.BLACK;
        this.width=0;
    }

    Myshape(int x1, int y1, int x2, int y2, Color color, float width)
    {
        this.x1=x1;this.y1=y1;
        this.x2=x2;this.y2=y2;
        this.color=color;
        this.width=width;
        this.checkFlow=0;
    }

    public abstract void draw(Graphics2D g);
}
