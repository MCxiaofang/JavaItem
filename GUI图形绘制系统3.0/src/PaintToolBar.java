import javax.swing.*;
import java.awt.*;

public class PaintToolBar extends JToolBar
{
    public JButton[]jb;
    public ImageIcon icon0,icon1,icon2,icon3,icon4,icon5,icon6;
    public PaintToolBarListener listener;
    public MainFrame frame;
    public int flag;

    PaintToolBar(MainFrame frame)
    {
        super("Tool",VERTICAL);
        this.frame=frame;
        this.flag=3;

        icon0=new ImageIcon(new ImageIcon("src/material/Line.png").getImage().getScaledInstance(18,18,0));
        icon1=new ImageIcon(new ImageIcon("src/material/Rectangle.png").getImage().getScaledInstance(18,18,0));
        icon2=new ImageIcon(new ImageIcon("src/material/Circle.png").getImage().getScaledInstance(18,18,0));
        icon3=new ImageIcon(new ImageIcon("src/material/follow.png").getImage().getScaledInstance(18,18,0));
        icon4=new ImageIcon(new ImageIcon("src/material/RoundRectangle.png").getImage().getScaledInstance(18,18,0));
        icon5=new ImageIcon(new ImageIcon("src/material/fillRec.png").getImage().getScaledInstance(18,18,0));
        icon6=new ImageIcon(new ImageIcon("src/material/fCircle.png").getImage().getScaledInstance(18,18,0));

        this.jb=new JButton[8];

        jb[0]=new JButton(icon0);
        jb[1]=new JButton(icon1);
        jb[2]=new JButton(icon2);
        jb[3]=new JButton(icon3);
        jb[4]=new JButton(icon4);
        jb[5]=new JButton(icon5);
        jb[6]=new JButton(icon6);
        jb[7]=new JButton("T");

        //设置按钮样式
        for(int i=0;i<jb.length;i++)
        {
            jb[i].setPreferredSize(new Dimension(24, 24));
            jb[i].setBackground(Color.WHITE);
            jb[i].setBorder(BorderFactory.createLineBorder(Color.cyan,0,true));
        }

        //将按钮添加
        this.listener=new PaintToolBarListener(this.frame);
        frame.paintpanel.setlistener(listener);
        for(int i=0;i<jb.length;i++)
        {
            jb[i].addActionListener(listener);
        }

        this.add(jb[3]);
        this.add(jb[0]);
        this.add(jb[1]);
        this.add(jb[4]);
        this.add(jb[2]);
        this.add(jb[5]);
        this.add(jb[6]);
        this.add(jb[7]);


        this.setFloatable(false);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(30,100));
    }
}
