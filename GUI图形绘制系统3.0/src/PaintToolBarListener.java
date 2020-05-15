import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class PaintToolBarListener extends MouseAdapter implements ActionListener, MouseMotionListener
{

    public Graphics2D g;
    public MainFrame frame;
    public int x1,x2,y1,y2,x3,y3;

    public PaintToolBarListener(MainFrame frame)
    {
        this.frame=frame;
    }


    public void actionPerformed(ActionEvent e)
    {
        if(frame.toolbar.flag==7&&e.getSource()!=frame.toolbar.jb[7]&&frame.list.size()!=0){
            frame.list.remove(frame.list.size()-1);
            frame.list.add(new Line(0,0,0,0,Color.BLACK,0));
            frame.paintpanel.repaint();
        }
        for(int i=0;i<frame.toolbar.jb.length;i++)
        {
            if(e.getSource()==frame.toolbar.jb[i]){
                this.frame.toolbar.flag=i;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        x1=e.getX();
        y1=e.getY();

        x3=e.getX();
        y3=e.getY();
        if(frame.toolbar.flag==3){
            //为了实时预览的逻辑连贯
            if(frame.list.size()!=0){
                frame.list.remove(frame.list.size()-1);
            }
        }
        frame.requestFocus();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        this.x2=e.getX();
        this.y2=e.getY();

        //之所以要先remove，后add，是因为只有在整个监听事件结束后repaint才会生效，如果将其放在最后则删除后才能重绘
        switch(frame.toolbar.flag) {
            case 0:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape line=new Line(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(line);
                frame.paintpanel.repaint();
                break;
            case 1:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape rec=new Rect(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(rec);
                frame.paintpanel.repaint();
                break;
            case 2:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape cir=new Circ(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(cir);
                frame.paintpanel.repaint();
                break;
            case 3:
                Myshape flow=new Line(1,x3,y3,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(flow);
                frame.paintpanel.repaint();

                x3=x2;
                y3=y2;
                break;
            case 4:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape rrec=new Rrec(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(rrec);
                frame.paintpanel.repaint();
                break;
            case 5:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape frec=new Frec(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(frec);
                frame.paintpanel.repaint();
                break;
            case 6:
                if(frame.list.size()!=0)
                    frame.list.remove(frame.list.size()-1);
                Myshape fcir=new Fcir(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(fcir);
                frame.paintpanel.repaint();
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        x2=e.getX();
        y2=e.getY();
        switch(this.frame.toolbar.flag){
            case 0:
                Myshape r_line=new Line(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_line);
                frame.paintpanel.repaint();
                break;
            case 1:
                Myshape r_rec=new Rect(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_rec);
                frame.paintpanel.repaint();
                break;
            case 2:
                Myshape r_cirC=new Circ(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_cirC);
                frame.paintpanel.repaint();
                break;
            case 3:
                Myshape r_flow=new Line(0,x3,y3,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add(r_flow);
                frame.paintpanel.repaint();
                frame.list.add(new Line(0,0,0,0,Color.BLACK,0));
                break;
            case 4:
                Myshape r_rRec=new Rrec(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_rRec);
                frame.paintpanel.repaint();
                break;
            case 5:
                Myshape r_fRec=new Frec(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_fRec);
                frame.paintpanel.repaint();
                break;
            case 6:
                Myshape r_fCir=new Fcir(x1,y1,x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_fCir);
                frame.paintpanel.repaint();
                break;
            case 7:
                Myshape r_text=new Text(frame.colorbar.inputt.getText(),x2,y2,frame.colorbar.usercolor,frame.colorbar.width);
                frame.list.add((Myshape)r_text);
                frame.paintpanel.repaint();
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        x2=e.getX();
        y2=e.getY();

        if(frame.toolbar.flag==7) {
            if (frame.list.size() != 0)
                frame.list.remove(frame.list.size() - 1);
            Myshape text = new Text(frame.colorbar.inputt.getText(), x2, y2, frame.colorbar.usercolor, frame.colorbar.width);
            frame.list.add(text);
            frame.paintpanel.repaint();
        }
    }
}
