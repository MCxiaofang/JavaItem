import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame
{
    public PaintToolBar toolbar;
    public PaintColorBar colorbar;
    public PaintMenuBar menubar;
    public PaintPanel paintpanel;
    public ArrayList<Myshape> list=new ArrayList<Myshape>();;

    MainFrame()
    {
        paintpanel=new PaintPanel(this);
        toolbar=new PaintToolBar(this);
        colorbar=new PaintColorBar(this);
        menubar=new PaintMenuBar(this);

        this.add(this.toolbar, BorderLayout.WEST);
        this.add(this.colorbar, BorderLayout.SOUTH);
        this.add(this.paintpanel,BorderLayout.CENTER);

        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar()==26) {
                    for(int i=0;i<2;i++){
                        if(!list.isEmpty())
                            list.remove(list.size()-1);
                    }
                    while(!list.isEmpty()&&list.get(list.size()-1).checkFlow==1){
                        list.remove(list.size()-1);
                    }
                    list.add(new Line(1,0,0,0,0,Color.BLACK,0));

                    paintpanel.repaint();
                }
                else if(e.getKeyChar()==1){
                    for(int i=list.size();i>0;i--){
                        Debugger.log(list.get(list.size()-i).checkFlow);
                    }
                    Debugger.log("-----------");
                }
            }
        });

        this.setJMenuBar(menubar);

        this.setTitle("画图");
        this.setSize(1200,700);
        this.setLocation(100,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
}
