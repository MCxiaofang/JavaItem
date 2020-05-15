import javax.swing.*;
import java.awt.*;

public class PaintColorBar extends JToolBar
{
    public JButton[]jb;
    public JButton stickb,clearb;
    public JTextField stickt,inputt;
    public JLabel jl0,jl1,jl2,jl3;
    public ImageIcon icon0,icon1,icon2,icon3,icon4,icon5,icon6;
    public PaintColorBarListener listener;
    public Color usercolor;
    public int width;
    public MainFrame frame;

    PaintColorBar(MainFrame frame)
    {
        super("Tool",HORIZONTAL);
        this.frame=frame;
        this.usercolor=Color.BLACK;
        this.width=5;

        icon0=new ImageIcon(new ImageIcon("src/material/RED.png").getImage().getScaledInstance(24,24,0));
        icon1=new ImageIcon(new ImageIcon("src/material/YELLOW.png").getImage().getScaledInstance(24,24,0));
        icon2=new ImageIcon(new ImageIcon("src/material/BLACK.png").getImage().getScaledInstance(24,24,0));
        icon3=new ImageIcon(new ImageIcon("src/material/GREEN.png").getImage().getScaledInstance(24,24,0));
        icon4=new ImageIcon(new ImageIcon("src/material/BLUE.png").getImage().getScaledInstance(24,24,0));
        icon5=new ImageIcon(new ImageIcon("src/material/WHITE.png").getImage().getScaledInstance(24,24,0));
        icon6=new ImageIcon(new ImageIcon("src/material/color.png").getImage().getScaledInstance(24,24,0));

        this.jb=new JButton[7];

        jb[0]=new JButton(icon0);
        jb[1]=new JButton(icon1);
        jb[2]=new JButton(icon2);
        jb[3]=new JButton(icon3);
        jb[4]=new JButton(icon4);
        jb[5]=new JButton(icon5);
        jb[6]=new JButton(icon6);

        stickb=new JButton("确认");
        clearb=new JButton("清空");
        stickt=new JTextField(3);
        inputt=new JTextField(20);
        jl0=new JLabel("    设置线条粗细/字体大小");
        jl1=new JLabel("    设置线条颜色");
        jl2=new JLabel("                                                                      ");
        jl3=new JLabel("文本框");

        jl0.setFont(new Font("宋体",Font.BOLD,17));
        jl1.setFont(new Font("宋体",Font.BOLD,17));
        jl3.setFont(new Font("宋体",Font.BOLD,17));
        inputt.setFont(new Font("楷体",Font.BOLD,15));
        stickb.setPreferredSize(new Dimension(40,20));
        clearb.setPreferredSize(new Dimension(40,20));


        //设置按钮样式
        for(int i=0;i<jb.length;i++)
        {
            jb[i].setPreferredSize(new Dimension(24, 24));
            jb[i].setBackground(Color.WHITE);
            jb[i].setBorder(BorderFactory.createLineBorder(Color.cyan,0,true));
        }

        this.add(jl3);
        this.add(inputt);
        this.add(jl2);
        this.add(clearb);
        this.add(jl0);
        this.add(stickt);
        this.add(stickb);
        this.add(jl1);


        this.listener=new PaintColorBarListener(this.frame);
        this.stickb.addActionListener(this.listener);
        this.clearb.addActionListener(this.listener);
        for(int i=0;i<jb.length;i++)
        {
            add(jb[i]);
            jb[i].addActionListener(listener);
        }

        this.setFloatable(false);
        this.setLayout(new FlowLayout(RIGHT));
        this.setPreferredSize(new Dimension(100,35));
    }
}
