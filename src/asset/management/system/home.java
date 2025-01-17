package asset.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame {
    home(){
        super("Dashboard");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,450);
        add(image);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/assetimg3.png"));
        Image ii2 = ii1.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel img = new JLabel(ii3);
        img.setBounds(500,200,400,200);
        image.add(img);


        JLabel heading = new JLabel("Asset Management System");
        heading.setBounds(280,40,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        image.add(heading);


        JLabel text = new JLabel("--We manage your assets--");
        text.setBounds(330,70,400,40);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        image.add(text);

        JButton add = new JButton("Add Asset");
        add.setBounds(150,170,170,35);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAsset();
                setVisible(false);
            }
        });
        image.add(add);

        JButton view = new JButton("View Asset");
        view.setBounds(150,230,170,35);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Asset();
                setVisible(false);
            }
        });
        image.add(view);

        JButton rem = new JButton("Remove Asset");
        rem.setBounds(150,290,170,35);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Remove_Asset();
            }
        });
        image.add(rem);



        JButton back = new JButton("Log Out");
        back.setBounds(150,350,170,35);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        image.add(back);



        setSize(900,450);
        setLocation(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new home();
    }
}
