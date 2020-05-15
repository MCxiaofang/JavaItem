import javax.swing.*;
import java.awt.*;

public class MySettings extends JFrame
{
    MainFrame frame;
    JPanel jp[]=new JPanel[10];
    JButton jb[]=new JButton[3];
    JLabel jl[]=new JLabel[5];
    JTextField jt[]=new JTextField[5];

    MySettings(MainFrame frame)
    {

        for(int i=0;i<jp.length;i++){
            jp[i]=new JPanel(new FlowLayout(FlowLayout.CENTER));
            jp[i].setBackground(new Color(0,150,195));
            this.add(jp[i]);
        }

        jb[0]=new JButton("确认");
        jb[1]=new JButton("取消");
        jb[2]=new JButton("应用");

        jl[0]=new JLabel("线条粗细");

        jt[0]=new JTextField(10);

/*        inputt=new JTextField(20);

        jl0.setFont(new Font("宋体",Font.BOLD,17));
        jl1.setFont(new Font("宋体",Font.BOLD,17));
        jl3.setFont(new Font("宋体",Font.BOLD,17));
        inputt.setFont(new Font("楷体",Font.BOLD,15));
        stickb.setPreferredSize(new Dimension(40,20));
        clearb.setPreferredSize(new Dimension(40,20));*/

        jp[1].add(jl[0]);
        jp[1].add(jt[0]);

        jp[9].add(jb[0]);
        jp[9].add(jb[1]);
        jp[9].add(jb[2]);
        jp[9].setLayout(new FlowLayout(FlowLayout.RIGHT));

        for(int i=0;i<jp.length;i++){
            this.add(jp[i]);
        }

        this.setLayout(new GridLayout(10,1));
        this.setTitle("格式");
        this.setSize(300,400);
        this.setLocation(550,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
}
