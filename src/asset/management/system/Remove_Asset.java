package asset.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_Asset extends JFrame implements ActionListener {

    Choice choiceAstId;

    JButton delete,back;

    Remove_Asset(){
        getContentPane().setBackground(new Color(120, 214, 243));

        JLabel label = new JLabel("Asset ID");
        label.setBounds(50,50,100,20);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);

        choiceAstId = new Choice();
        choiceAstId.setBounds(200,50,150,15);
        add(choiceAstId);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from asset");
            while (resultSet.next()){
                choiceAstId.add(resultSet.getString("AssetID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Description");
        labelName.setBounds(50,100,100,20);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,20);
        add(textName);

        JLabel labelCode = new JLabel("Asset Code");
        labelCode.setBounds(50,150,100,20);
        labelCode.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelCode);

        JLabel textCode = new JLabel();
        textCode.setBounds(200,150,100,20);
        add(textCode);

        JLabel labelPrice = new JLabel("Cost");
        labelPrice.setBounds(50,200,100,20);
        labelPrice.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPrice);

        JLabel textPrice = new JLabel();
        textPrice.setBounds(200,200,100,20);
        add(textPrice);

       try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from asset where AssetID = '"+choiceAstId.getSelectedItem()+"' ");
           while (resultSet.next()){
               textName.setText(resultSet.getString("Description"));
               textCode.setText(resultSet.getString("Asset_Code"));
               textPrice.setText(resultSet.getString("Aseet_Price"));
           }

       }catch (Exception e){
           e.printStackTrace();
       }

       choiceAstId.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               try{

                   conn c = new conn();
                   ResultSet resultSet = c.statement.executeQuery("select * from asset where AssetID = '"+choiceAstId.getSelectedItem()+"' ");
                   while (resultSet.next()){
                       textName.setText(resultSet.getString("Description"));
                       textCode.setText(resultSet.getString("Asset_Code"));
                       textPrice.setText(resultSet.getString("Aseet_Price"));
                   }

               }catch (Exception E){
                   E.printStackTrace();
               }
           }
       });


       delete = new JButton("Delete");
       delete.setBounds(80,300,100,30);
       delete.setBackground(Color.black);
       delete.setForeground(Color.white);
       delete.addActionListener(this);
       add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(600,80,200,200);
        add(img);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/rback.png"));
        Image ii2 = ii1.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image = new JLabel(ii3);
        image.setBounds(0,0,900,450);
        add(image);




        setSize(900,450);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
                conn c = new conn();
                String query = "delete from asset where AssetID = '"+choiceAstId.getSelectedItem()+"' ";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Asset Deleted Sucessfully");
                setVisible(false);
                new home();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Remove_Asset();
    }

}
