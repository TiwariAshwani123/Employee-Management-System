import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEMP;
    JButton searchbtn , print , update , back;
    View_Employee(){

        getContentPane().setBackground(new Color(0,0,128));
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        search.setForeground(Color.WHITE);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            while(rs.next()){
                choiceEMP.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            //DbUtils is used to take data and put it into table...We have to add library for DbUtils...
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));  

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn); 

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchbtn){
            String query = "select * from employee where empId = '"+choiceEMP.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception E){
                E.printStackTrace();
            }

        }
        if(e.getSource() == print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        if(e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        }
        if(e.getSource() == back){
            new Main_class();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
