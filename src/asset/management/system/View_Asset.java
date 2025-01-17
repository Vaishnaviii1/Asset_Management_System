package asset.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Asset extends JFrame implements ActionListener {
    JTable table;

    Choice choiceAstID;

    JButton searchbtn,update,back;

    View_Asset(){
        getContentPane().setBackground(new Color(120, 214, 243));

        JLabel search = new JLabel("Search By Asset Id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceAstID = new Choice();
        choiceAstID.setBounds(180,20,150,20);
        add(choiceAstID);


        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from asset");
            while (resultSet.next()){
                choiceAstID.add(resultSet.getString("AssetID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from asset");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,350);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        update = new JButton("Update");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(220,70,80,20);
        back.addActionListener(this);
        add(back);



        setSize(900,450);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn){
            String query = "select * from asset where AssetID ='"+choiceAstID.getSelectedItem()+"' ";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();

            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new Update_Asset(choiceAstID.getSelectedItem());
            
        }else {
            setVisible(false);
            new home();
        }

    }

    public static void main(String[] args) {
        new View_Asset();
    }
}
