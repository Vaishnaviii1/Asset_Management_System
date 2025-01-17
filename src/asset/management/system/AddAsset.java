package asset.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddAsset extends JFrame implements ActionListener {
     Random ran = new Random();

     int number = ran.nextInt(999999);

    JTextField   tname, tcost, tdep,tloc,tacode;

    JLabel tastid;

    JButton add,back;

    JDateChooser tpdate;
    AddAsset(){

        getContentPane().setBackground(new Color(120, 214, 243));

        JLabel heading = new JLabel("Add Asset Details");
        heading.setBounds(340,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Description");
        name.setBounds(50,90,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,90,150,20);
        add(tname);


        JLabel code = new JLabel("Asset Code");
        code.setBounds(50,130,150,30);
        code.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(code);

        tacode = new JTextField();
        tacode.setBounds(200,130,150,20);
        add(tacode);


        JLabel cost = new JLabel("Cost");
        cost.setBounds(50,170,150,30);
        cost.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(cost);

        tcost = new JTextField();
        tcost.setBounds(200,170,150,20);
        add(tcost);

        JLabel pdate = new JLabel("Purchase date");
        pdate.setBounds(50,210,150,30);
        pdate.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(pdate);

        tpdate = new JDateChooser();
        tpdate.setBounds(200,210,150,20);
        add(tpdate);

        JLabel dept = new JLabel("Department");
        dept.setBounds(50,250,150,30);
        dept.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(dept);

        tdep = new JTextField();
        tdep.setBounds(200,250,150,20);
        add(tdep);


        JLabel loc = new JLabel("Location");
        loc.setBounds(50,280,150,30);
        loc.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(loc);

        tloc = new JTextField();
        tloc.setBounds(200,280,150,20);
        add(tloc);

        JLabel astid = new JLabel("Asset ID");
        astid.setBounds(50,310,150,30);
        astid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(astid);

        tastid = new JLabel(""+number);
        tastid.setBounds(200,310,150,20);
        tastid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tastid.setForeground(Color.RED);
        add(tastid);

        add = new JButton("ADD");
        add.setBounds(600,200,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(600,250,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(900,450);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String astid = tastid.getText();
            String name = tname.getText();
            String code = tacode.getText();
            String cost = tcost.getText();
            String pdate = ((JTextField) tpdate.getDateEditor().getUiComponent()).getText();
            String dept = tdep.getText();
            String loc = tloc.getText();

            try{
                conn c = new conn();
                String query = "insert into asset values('"+astid+"' , '"+name+"' , '"+code+"' , '"+cost+"' , '"+pdate+"' , '"+dept+"' , '"+loc+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new home();

            }catch (Exception E){

                E.printStackTrace();
            }
        }else {
           setVisible(false);
           new home();
        }
    }

    public static void main(String[] args) {
        new AddAsset();
    }
}
