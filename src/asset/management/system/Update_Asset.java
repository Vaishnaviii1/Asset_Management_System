package asset.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Asset extends JFrame implements ActionListener {


    JTextField    tcost, tdep,tloc,tacode;

    JLabel tastid;

    JButton add,back;

    String number;

    Update_Asset(String number){

        this.number = number;
        getContentPane().setBackground(new Color(120, 214, 243));

        JLabel heading = new JLabel("Add Asset Details");
        heading.setBounds(340,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Description");
        name.setBounds(50,90,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(name);

        JLabel tname = new JLabel();
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

        JLabel tpdate = new JLabel();
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

        tastid = new JLabel();
        tastid.setBounds(200,310,150,20);
        tastid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tastid.setForeground(Color.RED);
        add(tastid);

        try{
            conn c = new conn();
            String query = "select * from asset where AssetID = '"+number+"' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("Description"));
                tacode.setText(resultSet.getString("Asset_Code"));
                tcost.setText(resultSet.getString("Aseet_Price"));
                tpdate.setText(resultSet.getString("Purchase_Date"));
                tdep.setText(resultSet.getString("Depatment_Name"));
                tloc.setText(resultSet.getString("Location"));
                tastid.setText(resultSet.getString("AssetID"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
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
            String code = tacode.getText();
            String cost = tcost.getText();
            String dept = tdep.getText();
            String loc = tloc.getText();

            try{
                conn c = new conn();
                String query = "update asset set Asset_Code = '"+code+"' , Aseet_Price = '"+cost+"' , Depatment_Name = '"+dept+"' , Location = '"+loc+"' where AssetID = '"+number+"'";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new home();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new View_Asset();
        }
    }

    public static void main(String[] args) {
        new Update_Asset("");
    }
}
