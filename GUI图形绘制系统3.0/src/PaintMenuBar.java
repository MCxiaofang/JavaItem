import javax.swing.*;
import java.awt.*;

public class PaintMenuBar extends JMenuBar
{
    JMenu mu0,mu1,mu2;
    JMenuItem mi0,mi1,mi2,mi3,mi4,mi5;
    PaintMenuBarListener listener;

    PaintMenuBar(MainFrame frame)
    {
        mi0=new JMenuItem("新建");
        mi1=new JMenuItem("打开");
        mi2=new JMenuItem("保存");
        mi3=new JMenuItem("帮助");
        mi4=new JMenuItem("格式");
        mi5=new JMenuItem("保存为jpg");

        mu0=new JMenu("File");
        mu1=new JMenu("Tool");
        mu2=new JMenu("Help");

        this.listener=new PaintMenuBarListener(frame);
        mi0.addActionListener(this.listener);
        mi1.addActionListener(this.listener);
        mi2.addActionListener(this.listener);
        mi3.addActionListener(this.listener);
        mi4.addActionListener(this.listener);
        mi5.addActionListener(this.listener);

        mu0.add(mi0);
        mu0.addSeparator();
        mu0.add(mi1);
        mu0.add(mi2);
        mu0.add(mi5);
        mu1.add(mi4);
        mu2.add(mi3);


        this.add(mu0);
        this.add(mu1);
        this.add(mu2);
    }
}
