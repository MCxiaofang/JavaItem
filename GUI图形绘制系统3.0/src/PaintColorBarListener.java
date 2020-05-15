import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintColorBarListener implements ActionListener {

    public MainFrame frame;


    public PaintColorBarListener(MainFrame frame)
    {
        this.frame=frame;
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<frame.colorbar.jb.length;i++)
        {
            if(e.getSource()==frame.colorbar.jb[i])
            {
                switch (i)
                {
                    case 0:frame.colorbar.usercolor=Color.RED;break;
                    case 1:frame.colorbar.usercolor=Color.YELLOW;break;
                    case 2:frame.colorbar.usercolor=Color.BLACK;break;
                    case 3:frame.colorbar.usercolor=Color.GREEN;break;
                    case 4:frame.colorbar.usercolor=Color.BLUE;break;
                    case 5:frame.colorbar.usercolor=Color.WHITE;break;
                    case 6:
                        Color color;
                        color = JColorChooser.showDialog(null, "自定义颜色", frame.colorbar.usercolor);
                        if (color != null) {
                            frame.colorbar.usercolor=color;
                        }
                        break;
                }
            }
        }
        if(e.getActionCommand()=="确认")
        {
            String regex = "[0-9]|[1-9][0-9]";

            if(frame.colorbar.stickt.getText().matches(regex)) {
                frame.colorbar.width=Integer.parseInt(frame.colorbar.stickt.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "请输入0-99之间的数", "范围提示", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getActionCommand()=="清空")
        {
            frame.list.removeAll(frame.list);
            frame.paintpanel.repaint();
        }
    }
}
