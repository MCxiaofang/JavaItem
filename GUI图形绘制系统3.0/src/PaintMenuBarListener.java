import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class PaintMenuBarListener implements ActionListener
{
    MainFrame frame;

    PaintMenuBarListener(MainFrame frame)
    {
        this.frame=frame;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int value=1;
        if (e.getActionCommand() == "帮助") {
            JOptionPane.showMessageDialog(null, "Tools内设置线条和字体格式\nCrtl+z撤销上一步绘画", "帮助", JOptionPane.QUESTION_MESSAGE);
        } else if (e.getActionCommand() == "新建") {
            if(frame.list.size()!=0)
                value = JOptionPane.showConfirmDialog(null, "是否需要保存当前文件？", "提示信息", 0);
            if (value == 0) {
                saveFile();
            }
                frame.list.removeAll(frame.list);
                frame.paintpanel.repaint();

        } else if (e.getActionCommand() == "打开") {
            if(frame.list.size()!=0)
                value = JOptionPane.showConfirmDialog(null, "是否需要保存当前文件？", "提示信息", 0);
            if (value == 0) {
                saveFile();
                value=1;
            }
                //清空容器里面的东西
                frame.list.removeAll(frame.list);
                frame.paintpanel.repaint();

                try {
                    //弹出选择对话框，选择需要读入的文件
                    JFileChooser chooser = new JFileChooser();
                    chooser.showOpenDialog(null);
                    File file = chooser.getSelectedFile();
                    //如果为选中文件
                    if (file == null) {
                        JOptionPane.showMessageDialog(null, "没有选择文件");
                    } else {
                        try {
                            //选中了相应的文件，则柑橘选中的文件创建对象输入流
                            FileInputStream fis = new FileInputStream(file);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            //将读出来的对象转换成父类对象的容器进行接收
                            ArrayList<Myshape> list = (ArrayList<Myshape>) ois.readObject();
                            //遍历容器里面的具体对象，将取出来的对象保存到容器里面
                            for (Myshape myshape : list) {
                                frame.list.add((Myshape) myshape);
                                //调用中心画板的repaint()方法，将容器里面的图形绘制出来
                                frame.paintpanel.repaint();
                            }
                            ois.close();
                        }catch(StreamCorruptedException | InvalidClassException | EOFException e2){
                            JOptionPane.showMessageDialog(null, "文件打开错误");
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

        } else if (e.getActionCommand() == "保存") {
            saveFile();
        }else if(e.getActionCommand() == "保存为jpg"){
            savejpgFile();
        }
        else if(e.getActionCommand()=="格式"){
            MySettings set=new MySettings(this.frame);
        }
    }

    public void saveFile(){
        //选择要保存的位置以及文件名字和信息
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        File file =chooser.getSelectedFile();

        if(file==null){
          JOptionPane.showMessageDialog(null, "没有选择文件");
        }else {
            try {
              //根据要保存的文件创建对象输出流
              FileOutputStream fis = new FileOutputStream(file);
              ObjectOutputStream oos = new ObjectOutputStream(fis);
                //将容器里面所绘制的图形利用对象流全部写入选中的文件中
                oos.writeObject(frame.list);
                JOptionPane.showMessageDialog(null, "保存成功！");
                oos.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
         }
    }

    public void savejpgFile(){
        //选择要保存的位置以及文件名字和信息
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG", "jpg");
        chooser.setFileFilter(filter);
        chooser.showSaveDialog(null);
        File file =chooser.getSelectedFile();

        if(file==null){
            JOptionPane.showMessageDialog(null, "没有选择文件");
        }else {
            try {
                System.out.println("666");
                Robot robot=new Robot();
                BufferedImage bi=robot.createScreenCapture(new Rectangle(150,110,1000,600));
                ImageIO.write(bi,"JPG",new File(file.toString()+".jpg"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}

