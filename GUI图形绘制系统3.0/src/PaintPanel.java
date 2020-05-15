import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaintPanel extends JPanel {
    PaintToolBarListener listener;
    MainFrame frame;

    public PaintPanel(MainFrame frame) {
        this.frame=frame;
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true), "画图区域"));
        this.setVisible(true);
    }
    public void setlistener(PaintToolBarListener listener)
    {
        this.listener=listener;
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<frame.list.size();i++)
        {
            Myshape myshape =(Myshape)frame.list.get(i);
            myshape.draw((Graphics2D) g);
        }
    }
}
