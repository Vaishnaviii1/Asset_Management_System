package asset.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    splash(){
        super("Asset Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image i2 = i1.getImage().getScaledInstance(640,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,640,400);
        add(image);

        setSize(640, 400);
        setLocation(400, 250);
        setLayout(null);
        setVisible(true);


        try{
            Thread.sleep(4000);
            setVisible(false);
            new login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new splash();
    }
}
