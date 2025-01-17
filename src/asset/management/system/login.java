package asset.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField userText;
    JPasswordField passwordText;

    JButton loginButton,cancleButton;

    login(){
        super("Login");
        getContentPane().setBackground(Color.gray);

        //text on frame
        JLabel username = new JLabel("UserName :");
        username.setBounds(300,60,100,20);
        add(username);
        //text bar
        userText = new JTextField();
        userText.setBounds(390,60,180,20);
        add(userText);



        JLabel password = new JLabel("Password :");
        password.setBounds(300, 110,100,20);
        add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(390,110,180,20);
        add(passwordText);


        loginButton = new JButton("login");
        loginButton.setBounds(330,150,100,20);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        add(loginButton);


        cancleButton = new JButton("Cancle");
        cancleButton.setBounds(450,150,100,20);
        cancleButton.setBackground(Color.black);
        cancleButton.setForeground(Color.white);
        cancleButton.addActionListener(this);
        add(cancleButton);

        ImageIcon profile1 = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profile2 = profile1.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon fprofile1 = new ImageIcon(profile2);
        JLabel profileLable = new JLabel(fprofile1);
        profileLable.setBounds(-20,-40,350,350);
        add(profileLable);




        setSize(640, 300);
        setLocation(400, 250);
        setLayout(null);
        setVisible(true);
    }

    @Override

    public  void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            try{
               String user = userText.getText();
               String pass = passwordText.getText();

               conn conn = new conn();

               String query = "SELECT * FROM login where username ='"+ user +"' and password = '"+ pass +"'";
               ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new home();

                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == cancleButton) {
            System.exit(90);

        }
    }
    public static void main(String[] args){
        new login();
    }
}
